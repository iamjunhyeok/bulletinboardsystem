package com.iamjunhyeok.bulletinboardsystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponse {
    private String userId;

    public UserLoginResponse(String userId) {
        this.userId = userId;
    }
}
