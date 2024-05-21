package com.iamjunhyeok.bulletinboardsystem.controller;

import com.iamjunhyeok.bulletinboardsystem.dto.UserDto;
import com.iamjunhyeok.bulletinboardsystem.dto.request.UserJoinRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.UserLoginRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.response.UserLoginResponse;
import com.iamjunhyeok.bulletinboardsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
            session.setAttribute("login", userLoginResponse);
            return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
        }
    }

    @GetMapping("/my-info")
    public ResponseEntity<UserLoginResponse> myInfo(HttpSession session) {
        UserLoginResponse login = (UserLoginResponse) session.getAttribute("login");
        if (login == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(login, HttpStatus.OK);
        }
    }
}
