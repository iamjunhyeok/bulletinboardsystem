package com.iamjunhyeok.bulletinboardsystem.dto.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {

    @NonNull
    private String userId;

    @NonNull
    private String password;
}
