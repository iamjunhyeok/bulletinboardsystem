package com.iamjunhyeok.bulletinboardsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateRequest {
    private String title;
    private String content;
}
