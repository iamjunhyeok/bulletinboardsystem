package com.iamjunhyeok.bulletinboardsystem.service;

import com.iamjunhyeok.bulletinboardsystem.dto.UserDto;
import com.iamjunhyeok.bulletinboardsystem.dto.request.UserJoinRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.UserLoginRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.response.UserLoginResponse;
import com.iamjunhyeok.bulletinboardsystem.exception.DuplicateUserIdException;
import com.iamjunhyeok.bulletinboardsystem.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.iamjunhyeok.bulletinboardsystem.utils.SHA256Util.encryptSHA256;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserMapper userMapper;

    @Transactional
    public void join(UserJoinRequest request) {
        UserDto byUserId = userMapper.findByUserId(request.getUserId());
        if (byUserId != null) {
            throw new DuplicateUserIdException("중복된 아이디입니다.");
        }
        request.setPassword(encryptSHA256(request.getPassword()));
        int insertCount = userMapper.join(request.getUserId(), request.getPassword());
        if (insertCount != 1) {
            log.error("join ERROR : {}", request);
            throw new RuntimeException("회원가입에 실패했습니다.");
        }
    }

    @Transactional
    public UserDto login(UserLoginRequest request) {
        request.setPassword(encryptSHA256(request.getPassword()));
        UserDto byUserIdAndPassword = userMapper.findByUserIdAndPassword(request.getUserId(), request.getPassword());
        return byUserIdAndPassword;
    }
}
