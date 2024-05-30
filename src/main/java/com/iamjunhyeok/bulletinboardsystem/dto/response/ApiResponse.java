package com.iamjunhyeok.bulletinboardsystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }
}
