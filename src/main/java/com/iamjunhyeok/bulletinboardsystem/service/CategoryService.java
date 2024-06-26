package com.iamjunhyeok.bulletinboardsystem.service;

import com.iamjunhyeok.bulletinboardsystem.dto.request.CategoryAddRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.CategoryUpdateRequest;
import com.iamjunhyeok.bulletinboardsystem.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Log4j2
public class CategoryService {

    private final CategoryMapper categoryMapper;

    @Transactional
    public void addCategory(CategoryAddRequest request) {
        categoryMapper.addCategory(request);
    }

    @Transactional
    public void updateCategory(Long id, CategoryUpdateRequest request) {
        categoryMapper.updateCategory(id, request.getName());
    }

    @Transactional
    public void deleteCategory(Long id) {
        categoryMapper.deleteCategory(id);
    }
}
