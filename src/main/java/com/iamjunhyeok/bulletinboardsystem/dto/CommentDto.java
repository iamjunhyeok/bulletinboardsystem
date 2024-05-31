package com.iamjunhyeok.bulletinboardsystem.dto;

import com.iamjunhyeok.bulletinboardsystem.dto.request.CommentAddRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.CommentUpdateRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private Long userId;
    private String content;
    private Long postId;
    private Long parentId;

    public static CommentDto of(Long postId, Long userId, CommentAddRequest request) {
        CommentDto commentDto = new CommentDto();
        commentDto.setPostId(postId);
        commentDto.setUserId(userId);
        commentDto.setContent(request.getContent());
        return commentDto;
    }

    public static CommentDto of(Long postId, Long parentId, Long userId, CommentAddRequest request) {
        CommentDto commentDto = new CommentDto();
        commentDto.setPostId(postId);
        commentDto.setParentId(parentId);
        commentDto.setUserId(userId);
        commentDto.setContent(request.getContent());
        return commentDto;
    }

    public static CommentDto of(Long id, Long userId, CommentUpdateRequest request) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(id);
        commentDto.setUserId(userId);
        commentDto.setContent(request.getContent());
        return commentDto;
    }

    public static CommentDto of(Long id, Long userId) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(id);
        commentDto.setUserId(userId);
        return commentDto;
    }
}
