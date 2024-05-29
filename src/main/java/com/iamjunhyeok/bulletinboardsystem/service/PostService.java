package com.iamjunhyeok.bulletinboardsystem.service;

import com.iamjunhyeok.bulletinboardsystem.dto.PostDto;
import com.iamjunhyeok.bulletinboardsystem.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostMapper postMapper;

    @Transactional
    public void createPost(PostDto postDto) {
        postMapper.createPost(postDto);
    }

    @Transactional
    public void updatePost(PostDto postDto) {
        postMapper.updatePost(postDto);
    }
}
