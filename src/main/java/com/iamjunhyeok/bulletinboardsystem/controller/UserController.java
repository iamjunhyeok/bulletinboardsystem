package com.iamjunhyeok.bulletinboardsystem.controller;

import com.iamjunhyeok.bulletinboardsystem.aop.LoginCheck;
import com.iamjunhyeok.bulletinboardsystem.dto.UserDto;
import com.iamjunhyeok.bulletinboardsystem.dto.request.UserChangePasswordRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.UserJoinRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.UserLoginRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.response.UserLoginResponse;
import com.iamjunhyeok.bulletinboardsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    public void join(@RequestBody UserJoinRequest request) {
        userService.join(request);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request, HttpSession session) {
        UserDto login = userService.login(request);
        if (login == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            UserLoginResponse userLoginResponse = new UserLoginResponse(login.getUserId());
            session.setAttribute("login", login.getId());
            return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
        }
    }

    @GetMapping("/my-info")
    @LoginCheck
    public ResponseEntity<UserDto> myInfo(HttpSession session) {
        Long id = (Long) session.getAttribute("login");
        UserDto userInfo = userService.getUserInfo(id);
        if (userInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        }
    }

    @PutMapping("/logout")
    @LoginCheck
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PutMapping("/change-password")
    @ResponseStatus(HttpStatus.OK)
    @LoginCheck
    public void changePassword(@RequestBody UserChangePasswordRequest request, HttpSession session) {
        Long id = (Long) session.getAttribute("login");
        String oldPassword = request.getOldPassword();
        String newPassword = request.getNewPassword();
        userService.changePassword(id, oldPassword, newPassword);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @LoginCheck
    public void deleteUser(HttpSession session) {
        Long id = (Long) session.getAttribute("login");
        userService.deleteUser(id);
    }
}
