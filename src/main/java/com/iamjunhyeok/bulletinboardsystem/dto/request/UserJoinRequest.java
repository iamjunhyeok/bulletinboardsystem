package com.iamjunhyeok.bulletinboardsystem.dto.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserJoinRequest {
    private Long id;

    @NonNull
    private String userId;

    @NonNull
    private String password;
}
