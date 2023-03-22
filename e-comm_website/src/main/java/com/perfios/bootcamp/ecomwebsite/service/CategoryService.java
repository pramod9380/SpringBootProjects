package com.perfios.bootcamp.ecomwebsite.service;

import com.perfios.bootcamp.ecomwebsite.beans.Category;
import com.perfios.bootcamp.ecomwebsite.exception.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {

    void saveCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(int id) throws CategoryNotFoundException;

    Category updateCategoryById(int id) throws CategoryNotFoundException;

    void deleteCategoryById(int id) throws CategoryNotFoundException;

}
