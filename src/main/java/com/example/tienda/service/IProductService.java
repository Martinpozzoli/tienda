package com.example.tienda.service;

import com.example.tienda.dto.ProductDTO;
import com.example.tienda.dto.ProductRequestDTO;

import java.util.List;

public interface IProductService {

    ProductDTO addProduct(ProductRequestDTO productRequestDTO);

    ProductDTO getProductById(Long id);

    List<ProductDTO> getAllProducts();

    ProductDTO updateProduct(ProductDTO productDTO);

    void deleteProduct(Long id);
}
