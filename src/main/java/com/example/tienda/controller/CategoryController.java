package com.example.tienda.controller;

import com.example.tienda.controller.documentation.CategoryControllerDoc;
import com.example.tienda.dto.CategoryDTO;
import com.example.tienda.dto.CategoryRequestDTO;
import com.example.tienda.exception.BadRequestException;
import com.example.tienda.service.ICategoryService;
import com.example.tienda.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Url.CATEGORIES)
public class CategoryController implements CategoryControllerDoc {

    @Autowired
    private ICategoryService categoryService;

    @Override
    @PostMapping
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO,
                                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult);
        }
        CategoryDTO categoryDTO = categoryService.addCategory(categoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @Override
    @PutMapping()
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult);
        }
        CategoryDTO updatedCategory = categoryService.updateCategory(categoryDTO);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "id") Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
