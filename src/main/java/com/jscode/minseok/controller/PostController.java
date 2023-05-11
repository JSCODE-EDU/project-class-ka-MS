package com.jscode.minseok.controller;

import com.jscode.minseok.dto.PostRequestDTO;
import com.jscode.minseok.dto.PostResponseDTO;
import com.jscode.minseok.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // 생성자 생성
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/save")
    public ResponseEntity<PostResponseDTO> postAdd(@RequestBody PostRequestDTO postRequest){
        PostResponseDTO postResponseDTO = postService.addPost(postRequest);
        return new ResponseEntity<>(postResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> postDetails(@PathVariable Long id){
        PostResponseDTO postResponseDTO = postService.findPostById(id);
        return new ResponseEntity<>(postResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> postList(){
        List<PostResponseDTO> postList = postService.selectPostList();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> postModify(@PathVariable Long id, @RequestBody PostRequestDTO postRequestDTO){
        PostResponseDTO postResponseDTO = postService.updatePost(id, postRequestDTO);
        return new ResponseEntity<>(postResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void postRemove(@PathVariable Long id){
        postService.deletePost(id);
    }




}
