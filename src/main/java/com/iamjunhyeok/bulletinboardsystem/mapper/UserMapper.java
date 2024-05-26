package com.iamjunhyeok.bulletinboardsystem.mapper;

import com.iamjunhyeok.bulletinboardsystem.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int join(@Param("userId") String userId, @Param("password") String password, @Param("salt") String salt);

    UserDto findByUserId(@Param("userId") String userId);

    UserDto findByUserIdAndPassword(@Param("userId") String userId, @Param("password") String password);

    String getSaltByUserId(@Param("userId") String userId);

    UserDto findById(Long id);
}
