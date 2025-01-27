package org.islom.dars111.service;

import org.islom.dars111.entity.Category;
import org.islom.dars111.payload.CategoryDto;
import org.islom.dars111.payload.Result;
import org.islom.dars111.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;


    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepo.getOne(id);
    }

    public Result saveCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());

        if(categoryDto.getParentCategoryId() != null) {
            Optional<Category> byId = categoryRepo.findById(categoryDto.getParentCategoryId());
            if(!byId.isPresent()) {
                return new Result("Bunday ota kategoriya mavjuid emas",false);
            }
            category.setParentCategory(byId.get());

        }

        boolean existsByName = categoryRepo.existsByName(categoryDto.getName());
        if (existsByName) {
            return new Result("Bunday Katalog mavjud", false);
        }
        categoryRepo.save(category);
        return new Result(" Katalog Saqlandi", true);
    }
}
