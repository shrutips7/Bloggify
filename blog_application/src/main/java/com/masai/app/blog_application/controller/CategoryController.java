package com.masai.app.blog_application.controller;

import com.masai.app.blog_application.entity.Category;
import com.masai.app.blog_application.entity.Comment;
import com.masai.app.blog_application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategory(){
        List<Category> categoryInfo=categoryService.getAllCategory();
        return categoryInfo;
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category){
        Category category1=categoryService.addCategory(category);
        return category1;
    }

    @PutMapping("/category")
    public String updateCategory(@RequestBody Category category){
        String category1=categoryService.updateCategory(category);
        return category1;
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable("id") int categoryId){
        String msg=categoryService.deleteCategory(categoryId);
        return msg;
    }
}
