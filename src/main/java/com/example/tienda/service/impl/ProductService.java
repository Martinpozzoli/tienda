package com.example.tienda.service.impl;

import com.example.tienda.dto.ProductDTO;
import com.example.tienda.dto.ProductRequestDTO;
import com.example.tienda.exception.ConflictException;
import com.example.tienda.exception.NotFoundException;
import com.example.tienda.mapper.ProductMapper;
import com.example.tienda.model.Product;
import com.example.tienda.repository.ProductRepository;
import com.example.tienda.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO addProduct(ProductRequestDTO productRequestDTO) {
        Optional<Product> product = productRepository.findByName(productRequestDTO.getName());
        if (product.isPresent()) {
            throw new ConflictException("There is already a product with that name.");
        }
        Product newProduct = productMapper.productRequestDto2Entity(productRequestDTO);
        Product savedProduct = productRepository.save(newProduct);
        return productMapper.productEntity2Dto(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Product not found"));
        return productMapper.productEntity2Dto(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new NotFoundException("Products list is empty");
        }
        return productMapper.productList2DtoList(products);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        productRepository.findById(productDTO.getId())
                .orElseThrow(()-> new NotFoundException("Product not found"));
        Product product = productMapper.productDto2Entity(productDTO);
        Product updatedProduct = productRepository.save(product);
        return productMapper.productEntity2Dto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        try{
            productRepository.deleteById(id);
        }catch (Exception e){
            throw new NotFoundException("Product not found");
        }
    }
}
