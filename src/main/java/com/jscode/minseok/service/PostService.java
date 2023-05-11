package com.jscode.minseok.service;

import com.jscode.minseok.dto.PostRequestDTO;
import com.jscode.minseok.dto.PostResponseDTO;

import java.util.List;

public interface PostService {
    // crud 작성

    PostResponseDTO addPost(PostRequestDTO postRequestDTO);

    PostResponseDTO findPostById(Long id);

    List<PostResponseDTO> selectPostList();

    PostResponseDTO updatePost(Long id, PostRequestDTO postRequestDTO);

    void deletePost(Long id);
}
