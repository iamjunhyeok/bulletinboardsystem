package com.iamjunhyeok.bulletinboardsystem.controller;

import com.iamjunhyeok.bulletinboardsystem.aop.LoginCheck;
import com.iamjunhyeok.bulletinboardsystem.dto.PostDto;
import com.iamjunhyeok.bulletinboardsystem.dto.request.PostAddRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.PostUpdateRequest;
import com.iamjunhyeok.bulletinboardsystem.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Log4j2
public class PostController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck
    public void createPost(@RequestBody PostAddRequest request, HttpSession session) {
        Long userId = (Long) session.getAttribute("login");
        PostDto postDto = PostDto.of(userId, request);
        postService.createPost(postDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @LoginCheck
    public void updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest request, HttpSession session) {
        Long userId = (Long) session.getAttribute("login");
        PostDto postDto = PostDto.of(id, userId, request);
        postService.updatePost(postDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @LoginCheck
    public void deletePost(@PathVariable Long id, HttpSession session) {
        Long userId = (Long) session.getAttribute("login");
        PostDto postDto = PostDto.of(id, userId);
        postService.deletePost(postDto);
    }
}
