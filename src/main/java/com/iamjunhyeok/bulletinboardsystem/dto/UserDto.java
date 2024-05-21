package com.iamjunhyeok.bulletinboardsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String userId;
    private String password;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
}
