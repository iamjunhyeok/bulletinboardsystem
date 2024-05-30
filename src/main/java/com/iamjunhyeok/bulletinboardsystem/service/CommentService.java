package com.iamjunhyeok.bulletinboardsystem.service;

import com.iamjunhyeok.bulletinboardsystem.dto.CommentDto;
import com.iamjunhyeok.bulletinboardsystem.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Log4j2
public class CommentService {

    private final CommentMapper commentMapper;

    @Transactional
    public void createComment(CommentDto commentDto) {
        commentMapper.createComment(commentDto);
    }
}
