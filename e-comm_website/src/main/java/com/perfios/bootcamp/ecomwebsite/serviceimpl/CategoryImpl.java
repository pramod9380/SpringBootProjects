package com.perfios.bootcamp.ecomwebsite.serviceimpl;

import com.perfios.bootcamp.ecomwebsite.beans.Category;
import com.perfios.bootcamp.ecomwebsite.exception.CategoryNotFoundException;
import com.perfios.bootcamp.ecomwebsite.repository.CategoryRepo;
import com.perfios.bootcamp.ecomwebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public void saveCategory(Category category) {
        categoryRepo.saveAndFlush(category);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories;
    }

    @Override
    public Category getCategoryById(int id) throws CategoryNotFoundException {
        categoryRepo.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category Not Found With this id, Please Enter a valid category id!!"));
        return categoryRepo.findById(id).get();
    }

    @Override
    public Category updateCategoryById( int id) throws CategoryNotFoundException {
        categoryRepo.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category Not Found With this id, Please Enter a valid category id!!"));
        Category category = categoryRepo.findById(id).get();
        return category;
    }

    @Override
    public void deleteCategoryById(int id) throws CategoryNotFoundException {
        categoryRepo.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category Not Found With this id, Please Enter a valid category id!!"));
        categoryRepo.deleteById(id);
    }
}
