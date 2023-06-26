package com.example.tienda.controller.documentation;

import com.example.tienda.dto.CategoryDTO;
import com.example.tienda.dto.CategoryRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface CategoryControllerDoc {

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category successfully created",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Category",
                                            description = "CategoryDTO",
                                            value = "{\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"name\": \"Panaderia\",\n" +
                                                    "    \"description\": \"Hecho con harina\",\n" +
                                                    "    \"imageUrl\": \"vino.jpg\"\n" +
                                                    "}")
                            }
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid field",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<CategoryDTO> addCategory(CategoryRequestDTO categoryRequestDTO,
                                            BindingResult bindingResult);

    @Operation(summary = "Get a category by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Category",
                                            description = "CategoryDTO",
                                            value = "{\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"name\": \"Panaderia\",\n" +
                                                    "    \"description\": \"Hecho con harina\",\n" +
                                                    "    \"imageUrl\": \"vino.jpg\"\n" +
                                                    "}")
                            }
                    )),
            @ApiResponse(responseCode = "404", description = "Category not found",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<CategoryDTO> getCategoryById(Long id);

    @Operation(summary = "Get a list of categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categories found",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Category",
                                            description = "CategoryDTO",
                                            value = "[\n" +
                                                    "    {\n" +
                                                    "        \"id\": 1,\n" +
                                                    "        \"name\": \"Bebidas alcoholicas\",\n" +
                                                    "        \"description\": \"Sale del vino\",\n" +
                                                    "        \"imageUrl\": \"vino.jpg\"\n" +
                                                    "    },\n" +
                                                    "    {\n" +
                                                    "        \"id\": 2,\n" +
                                                    "        \"name\": \"Panaderia\",\n" +
                                                    "        \"description\": \"Hecho con harinas\",\n" +
                                                    "        \"imageUrl\": \"pan.jpg\"\n" +
                                                    "    }\n" +
                                                    "]")
                            }
                    )),
            @ApiResponse(responseCode = "404", description = "The list is empty",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<List<CategoryDTO>> getAllCategories();

    @Operation(summary = "Update a category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category successfully updated",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Category",
                                            description = "CategoryDTO",
                                            value = "{\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"name\": \"Panaderia\",\n" +
                                                    "    \"description\": \"Hecho con harina y huevo\",\n" +
                                                    "    \"imageUrl\": \"vino.jpg\"\n" +
                                                    "}")
                            }
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid field",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<CategoryDTO> updateCategory(CategoryDTO categoryDTO,
                                               BindingResult bindingResult);

    @Operation(summary = "Delete a category by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Category successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<Void> deleteCategory(Long id);
}
