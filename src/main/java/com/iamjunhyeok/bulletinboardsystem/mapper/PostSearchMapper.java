package com.iamjunhyeok.bulletinboardsystem.mapper;

import com.iamjunhyeok.bulletinboardsystem.dto.PostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostSearchMapper {

    List<PostDto> getPosts(PostDto postDto);
}
