package com.iamjunhyeok.bulletinboardsystem.controller;

import com.iamjunhyeok.bulletinboardsystem.dto.PostDto;
import com.iamjunhyeok.bulletinboardsystem.dto.request.PostSearchRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.response.ApiResponse;
import com.iamjunhyeok.bulletinboardsystem.service.PostSearchService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts/search")
@RequiredArgsConstructor
@Log4j2
public class PostSearchController {

    private final PostSearchService postSearchService;

    @GetMapping
    public ApiResponse searchPosts(PostSearchRequest request) {
        PostDto postDto = PostDto.from(request);
        List<PostDto> posts = postSearchService.getPosts(postDto);

        List<PostSearchResponse> postList = posts.stream()
                .map(PostSearchResponse::from)
                .collect(Collectors.toList());
        return new ApiResponse<>(postList);
    }

    @Getter
    @Setter
    private static class PostSearchResponse {
        private String title;
        private String content;

        public static PostSearchResponse from(PostDto postDto) {
            PostSearchResponse response = new PostSearchResponse();
            response.setTitle(postDto.getTitle());
            response.setContent(postDto.getContent());
            return response;
        }
    }
}
