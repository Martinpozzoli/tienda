package com.example.tienda.service;

import com.example.tienda.dto.CategoryDTO;
import com.example.tienda.dto.CategoryRequestDTO;

import java.util.List;

public interface ICategoryService {

    CategoryDTO addCategory(CategoryRequestDTO categoryRequestDTO);

    CategoryDTO getCategoryById(Long id);

    List<CategoryDTO> getAllCategories();

    CategoryDTO updateCategory(CategoryDTO categoryDTO);

    void deleteCategory(Long id);
}
