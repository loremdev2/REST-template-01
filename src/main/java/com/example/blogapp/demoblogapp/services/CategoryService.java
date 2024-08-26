package com.example.blogapp.demoblogapp.services;

import com.example.blogapp.demoblogapp.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO category);
    CategoryDTO updateCategory(CategoryDTO user, Integer categoryId);
    CategoryDTO getCategoryById(Integer id);
    List<CategoryDTO> getAllCategories();
    void deleteUser(Integer categoryId);

}
