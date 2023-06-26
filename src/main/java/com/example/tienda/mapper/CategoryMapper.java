package com.example.tienda.mapper;

import com.example.tienda.dto.CategoryDTO;
import com.example.tienda.dto.CategoryRequestDTO;
import com.example.tienda.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public Category categoryDto2Entity(CategoryDTO dto){
        Category entity = new Category();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        return entity;
    }

    public Category categoryRequestDto2Entity(CategoryRequestDTO requestDTO){
        Category entity = new Category();
        entity.setName(requestDTO.getName());
        entity.setDescription(requestDTO.getDescription());
        entity.setImageUrl(requestDTO.getImageUrl());
        return entity;
    }

    public CategoryDTO categoryEntity2Dto(Category entity){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setImageUrl(entity.getImageUrl());
        return dto;
    }
    
    public List<CategoryDTO> categoryList2DtoList(List<Category> categoryList){
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDTOList.add(this.categoryEntity2Dto(category));
        }
        return categoryDTOList;
    }
}
