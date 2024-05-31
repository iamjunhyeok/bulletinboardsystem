package com.iamjunhyeok.bulletinboardsystem.service;

import com.iamjunhyeok.bulletinboardsystem.dto.PostDto;
import com.iamjunhyeok.bulletinboardsystem.mapper.PostSearchMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Log4j2
public class PostSearchService {

    private final PostSearchMapper postSearchMapper;

    public List<PostDto> getPosts(PostDto postDto) {
        List<PostDto> posts = new ArrayList<>();
        try {
            posts = postSearchMapper.getPosts(postDto);
        } catch (RuntimeException e) {
            log.error("getPosts ERROR : {}", e.getMessage());
        }
        return posts;
    }
}
