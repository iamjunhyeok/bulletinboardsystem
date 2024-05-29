package com.iamjunhyeok.bulletinboardsystem.dto;

import com.iamjunhyeok.bulletinboardsystem.dto.request.PostAddRequest;
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
}
