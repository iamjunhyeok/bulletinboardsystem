package com.iamjunhyeok.bulletinboardsystem.controller;

import com.iamjunhyeok.bulletinboardsystem.aop.LoginCheck;
import com.iamjunhyeok.bulletinboardsystem.dto.CommentDto;
import com.iamjunhyeok.bulletinboardsystem.dto.request.CommentAddRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.CommentUpdateRequest;
import com.iamjunhyeok.bulletinboardsystem.service.CommentService;
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
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{postId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck
    public void createComment(@PathVariable Long postId, @RequestBody CommentAddRequest request, HttpSession session) {
        Long userId = (Long) session.getAttribute("login");
        CommentDto commentDto = CommentDto.of(postId, userId, request);
        commentService.createComment(commentDto);
    }

    @PostMapping("/{postId}/comments/{parentId}")
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck
    public void createComment(@PathVariable Long postId, @PathVariable Long parentId, @RequestBody CommentAddRequest request, HttpSession session) {
        Long userId = (Long) session.getAttribute("login");
        CommentDto commentDto = CommentDto.of(postId, parentId, userId, request);
        commentService.createComment(commentDto);
    }

    @PutMapping("/{postId}/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @LoginCheck
    public void updateComment(@PathVariable Long id, @RequestBody CommentUpdateRequest request, HttpSession session) {
        Long userId = (Long) session.getAttribute("login");
        CommentDto commentDto = CommentDto.of(id, userId, request);
        commentService.updateComment(commentDto);
    }

    @DeleteMapping("/{postId}/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @LoginCheck
    public void deleteComment(@PathVariable Long id, HttpSession session) {
        Long userId = (Long) session.getAttribute("login");
        CommentDto commentDto = CommentDto.of(id, userId);
        commentService.deleteComment(commentDto);
    }
}
