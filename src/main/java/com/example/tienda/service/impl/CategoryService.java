package com.example.tienda.service.impl;

import com.example.tienda.dto.CategoryDTO;
import com.example.tienda.dto.CategoryRequestDTO;
import com.example.tienda.exception.ConflictException;
import com.example.tienda.exception.NotFoundException;
import com.example.tienda.mapper.CategoryMapper;
import com.example.tienda.model.Category;
import com.example.tienda.repository.CategoryRepository;
import com.example.tienda.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO addCategory(CategoryRequestDTO categoryRequestDTO) {
        Optional<Category> category = categoryRepository.findByName(categoryRequestDTO.getName());
        if (category.isPresent()) {
            throw new ConflictException("There is already a category with that name");
        }
        Category newCategory = categoryMapper.categoryRequestDto2Entity(categoryRequestDTO);
        Category savedCategory = categoryRepository.save(newCategory);
        return categoryMapper.categoryEntity2Dto(savedCategory);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found"));
        return categoryMapper.categoryEntity2Dto(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new NotFoundException("Categories list is empty");
        }
        return categoryMapper.categoryList2DtoList(categories);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        categoryRepository.findById(categoryDTO.getId())
                .orElseThrow(()-> new NotFoundException("Category not found"));
        Category category = categoryMapper.categoryDto2Entity(categoryDTO);
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.categoryEntity2Dto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
        }catch(Exception e){
            throw new NotFoundException("Category not found");
        }
    }
}
