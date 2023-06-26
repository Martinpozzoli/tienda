package com.example.tienda.controller;

import com.example.tienda.controller.documentation.ProductControllerDoc;
import com.example.tienda.dto.ProductDTO;
import com.example.tienda.dto.ProductRequestDTO;
import com.example.tienda.exception.BadRequestException;
import com.example.tienda.service.IProductService;
import com.example.tienda.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Url.PRODUCTS)
public class ProductController implements ProductControllerDoc {

    @Autowired
    private IProductService productService;

    @Override
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO,
                                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult);
        }
        ProductDTO productDTO = productService.addProduct(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @Override
    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO productDTO,
                                                    BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult);
        }
        ProductDTO updatedProduct = productService.updateProduct(productDTO);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
