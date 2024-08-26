package com.example.blogapp.demoblogapp.services.impl;

import com.example.blogapp.demoblogapp.entities.Category;
import com.example.blogapp.demoblogapp.exceptions.ResourceNotFoundException;
import com.example.blogapp.demoblogapp.payloads.CategoryDTO;
import com.example.blogapp.demoblogapp.repositories.CategoryRepo;
import com.example.blogapp.demoblogapp.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
   @Autowired
    private CategoryRepo categoryRepo;

   @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category= this.modelMapper.map(categoryDTO, Category.class);
        Category addedCategory= this.categoryRepo.save(category);
        return this.modelMapper.map(addedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category category= this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(category.getCategoryDescription());
        Category updatedCategory=this.categoryRepo.save(category);
        return this.modelMapper.map(updatedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO getCategoryById(Integer id) {
        return null;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return null;
    }

    @Override
    public void deleteUser(Integer categoryId) {

    }
}
