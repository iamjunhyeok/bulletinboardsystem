package com.iamjunhyeok.bulletinboardsystem.controller;

import com.iamjunhyeok.bulletinboardsystem.aop.LoginCheck;
import com.iamjunhyeok.bulletinboardsystem.dto.request.CategoryAddRequest;
import com.iamjunhyeok.bulletinboardsystem.dto.request.CategoryUpdateRequest;
import com.iamjunhyeok.bulletinboardsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Log4j2
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck
    public void addCategory(@RequestBody CategoryAddRequest request) {
        categoryService.addCategory(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @LoginCheck
    public void updateCategory(@PathVariable("id") Long id, @RequestBody CategoryUpdateRequest request) {
        categoryService.updateCategory(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @LoginCheck
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
