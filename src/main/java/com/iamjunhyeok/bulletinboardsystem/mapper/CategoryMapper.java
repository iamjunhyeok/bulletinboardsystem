package com.iamjunhyeok.bulletinboardsystem.mapper;

import com.iamjunhyeok.bulletinboardsystem.dto.request.CategoryAddRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {

    int addCategory(CategoryAddRequest request);
}
