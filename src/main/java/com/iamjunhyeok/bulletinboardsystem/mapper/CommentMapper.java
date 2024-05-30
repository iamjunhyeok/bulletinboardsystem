package com.iamjunhyeok.bulletinboardsystem.mapper;

import com.iamjunhyeok.bulletinboardsystem.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    int createComment(CommentDto commentDto);
}
