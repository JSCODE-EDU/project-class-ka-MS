package com.jscode.minseok.service;

import com.jscode.minseok.domain.Post;
import com.jscode.minseok.dto.PostRequestDTO;
import com.jscode.minseok.dto.PostResponseDTO;
import com.jscode.minseok.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // 생성자 생성
public class PostServiceImpl implements PostService {
    // 예외처리 해 줘야합니다.

    private final PostMapper postMapper;


    @Override
    public PostResponseDTO addPost(PostRequestDTO postRequestDTO) {
        Post post = new Post();
        post.setTitle(postRequestDTO.getTitle());
        post.setContent(postRequestDTO.getContent());
        postMapper.insertPost(post);
        // Mybatis로 id값 반환 받아서 넘김 insert 후에 post 인스턴스에 id 값이 저장되게됨
        Post updatedPost = postMapper.selectPost(post.getId());
        return new PostResponseDTO(
                updatedPost.getId(),
                updatedPost.getTitle(),
                updatedPost.getContent(),
                updatedPost.getCreatedat());
    }

    @Override
    public PostResponseDTO findPostById(Long id) {
        Post post =  postMapper.selectPost(id);
        return new PostResponseDTO(
                post.getId()
                , post.getTitle()
                , post.getContent()
                , post.getCreatedat());
    }

    @Override
    public List<PostResponseDTO> selectPostList() {
        List<Post> pList = postMapper.selectPostList();
        return pList.stream().map(post -> new PostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedat()
        )).collect(Collectors.toList());
    }

    @Override
    public PostResponseDTO updatePost(Long id, PostRequestDTO postRequestDTO) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(postRequestDTO.getTitle());
        post.setContent(postRequestDTO.getContent());
        postMapper.updatePost(post);
        Post updatedPost = postMapper.selectPost(id);
        return new PostResponseDTO(
                updatedPost.getId(),
                updatedPost.getTitle(),
                updatedPost.getContent(),
                updatedPost.getCreatedat());

    }

    @Override
    public void deletePost(Long id) {
        postMapper.deletePost(id);
    }
}
