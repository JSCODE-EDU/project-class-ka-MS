package com.jscode.minseok.repository;

import com.jscode.minseok.domain.Post;
import com.jscode.minseok.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    void insertBoard() {
        Post params = new Post(3L,"test1","test1",null);
        System.out.println("번호 : " + postMapper.insertPost(params) + " :: " +params.getId());
    }

    @Test
    void selectBoard() {
        Post a = postMapper.selectPost(3L);
        System.out.println(a);
    }

    @Test
    void selectBoardList() {
        List<Post> a = postMapper.selectPostList();
        System.out.println(a.size()+"개");
    }

    @Test
    void updateBoard() {
        Post params = new Post(2L,"수정1", "수정1",null);
        postMapper.updatePost(params);
    }

    @Test
    void deleteBoard() {
        postMapper.deletePost(1L);
    }

    @Test
    void selectPostsByTitleContaining() {
        String title = "t";
        List<Post> a = postMapper.selectPostsByTitleContaining("t");
        System.out.println(a.size()+"개");
        for(Post post : a) {
            System.out.println(post);
        }
    }

}