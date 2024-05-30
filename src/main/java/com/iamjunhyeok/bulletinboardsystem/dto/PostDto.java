package com.iamjunhyeok.bulletinboardsystem.dto;

import com.iamjunhyeok.bulletinboardsystem.dto.request.PostAddRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.PostSearchRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.PostUpdateRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private Long categoryId;
    private Long userId;
    private int views;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PostDto of(Long userId, PostAddRequest request) {
        PostDto postDto = new PostDto();
        postDto.setUserId(userId);
        postDto.setTitle(request.getTitle());
        postDto.setContent(request.getContent());
        postDto.setCategoryId(request.getCategoryId());
        return postDto;
    }

    public static PostDto of(Long id, Long userId, PostUpdateRequest request) {
        PostDto postDto = new PostDto();
        postDto.setId(id);
        postDto.setUserId(userId);
        postDto.setTitle(request.getTitle());
        postDto.setContent(request.getContent());
        return postDto;
    }

    public static PostDto of(Long id, Long userId) {
        PostDto postDto = new PostDto();
        postDto.setId(id);
        postDto.setUserId(userId);
        return postDto;
    }

    public static PostDto from(PostSearchRequest request) {
        PostDto postDto = new PostDto();
        postDto.setTitle(request.getTitle());
        postDto.setContent(request.getContent());
        return postDto;
    }
}
