package com.masai.app.blog_application.service;

import com.masai.app.blog_application.entity.Category;
import com.masai.app.blog_application.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public String updateCategory(Category category) {
        Optional<Category> category1=categoryRepository.findById(category.getCategoryId());
        if(category1.isEmpty()){
            return "Repository Error";
        }
        category1.get().setCategoryName(category.getCategoryName());
        categoryRepository.save(category1.get());
        return "Info Updated";

    }

    public String deleteCategory(int categoryId) {
        Category category1=categoryRepository.findById(categoryId).get();
        try{
            categoryRepository.delete(category1);
            return "Successfully deleted";
        }
        catch(Exception ex){
            return "Delete Failed";
        }
    }
}
