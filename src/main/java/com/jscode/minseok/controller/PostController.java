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
    public List<PostResponseDTO> postList(){
        return postService.selectPostList();
    }
    
    // 검색어를 받는 domain을 추가해 줘야 하는게 맞는지 모르겠다. api 규격도 이렇게 하는게 맞는지 모르겠음
    @GetMapping("/search") // /search?title=검색어
    public List<PostResponseDTO> searchPostsByTitle(@RequestParam String title){
        return postService.selectPostsByTitleContaining(title);
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
