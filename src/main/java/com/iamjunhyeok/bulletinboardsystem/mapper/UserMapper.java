package com.iamjunhyeok.bulletinboardsystem.mapper;

import com.iamjunhyeok.bulletinboardsystem.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int join(@Param("userId") String userId, @Param("password") String password, @Param("salt") String salt);

    UserDto findByUserId(@Param("userId") String userId);

    UserDto findByUserIdAndPassword(@Param("userId") String userId, @Param("password") String password);

    UserDto findByIdAndPassword(@Param("id") Long id, @Param("password") String password);

    UserDto findById(Long id);

    String getSaltByUserId(@Param("userId") String userId);

    String getSaltById(@Param("id") Long id);

    int changePassword(Long id, String password, String salt);

    int updateDeleteFlag(Long id, int deleteFlag);
}
