package org.islom.dars111.controller;

import org.islom.dars111.entity.Category;
import org.islom.dars111.payload.CategoryDto;
import org.islom.dars111.payload.Result;
import org.islom.dars111.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto) {

        Result result = categoryService.saveCategory(categoryDto);
        return result;

    }
}
