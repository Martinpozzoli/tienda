package com.example.tienda.mapper;

import com.example.tienda.dto.ProductDTO;
import com.example.tienda.dto.ProductRequestDTO;
import com.example.tienda.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    public Product productDto2Entity(ProductDTO dto){
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setPrice(dto.getPrice());
        entity.setStock(dto.getStock());
        entity.setCategory(categoryMapper.categoryDto2Entity(dto.getCategoryDTO()));
        return entity;
    }

    public Product productRequestDto2Entity(ProductRequestDTO requestDTO){
        Product entity = new Product();
        entity.setName(requestDTO.getName());
        entity.setDescription(requestDTO.getDescription());
        entity.setImageUrl(requestDTO.getImageUrl());
        entity.setPrice(requestDTO.getPrice());
        entity.setStock(requestDTO.getStock());
        entity.setCategory(categoryMapper.categoryDto2Entity(requestDTO.getCategoryDTO()));
        return entity;
    }

    public ProductDTO productEntity2Dto(Product entity){
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setImageUrl(entity.getImageUrl());
        dto.setPrice(entity.getPrice());
        dto.setStock(entity.getStock());
        dto.setCategoryDTO(categoryMapper.categoryEntity2Dto(entity.getCategory()));
        return dto;
    }

    public List<ProductDTO> productList2DtoList(List<Product> productList){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            productDTOList.add(this.productEntity2Dto(product));
        }
        return productDTOList;
    }

    public List<Product> productDtoList2EntityList(List<ProductDTO> productDtoList){
        List<Product> productList = new ArrayList<>();
        for (ProductDTO productDTO : productDtoList) {
            productList.add(this.productDto2Entity(productDTO));
        }
        return productList;
    }
}
