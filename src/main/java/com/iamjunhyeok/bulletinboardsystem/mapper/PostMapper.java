package com.iamjunhyeok.bulletinboardsystem.mapper;

import com.iamjunhyeok.bulletinboardsystem.dto.PostDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

    int createPost(PostDto postDto);
}
