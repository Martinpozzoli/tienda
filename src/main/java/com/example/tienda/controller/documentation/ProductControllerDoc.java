package com.example.tienda.controller.documentation;

import com.example.tienda.dto.ProductDTO;
import com.example.tienda.dto.ProductRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProductControllerDoc {

    @Operation(summary = "Add a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product successfully created",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Product",
                                            description = "ProductDTO",
                                            value = "{\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"name\": \"Vino\",\n" +
                                                    "    \"description\": \"Viene de Mendoza\",\n" +
                                                    "    \"imageUrl\": \"botella.jpg\",\n" +
                                                    "    \"price\": 750.50,\n" +
                                                    "    \"stock\": 25,\n" +
                                                    "    \"categoryDTO\": {\n" +
                                                    "        \"id\": 1,\n" +
                                                    "        \"name\": \"Bebidas alcoholicas\",\n" +
                                                    "        \"description\": \"Sale del vino\",\n" +
                                                    "        \"imageUrl\": \"vino.jpg\"\n" +
                                                    "    }\n" +
                                                    "}")
                            }
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid field",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<ProductDTO> addProduct(ProductRequestDTO productRequestDTO,
                                          BindingResult bindingResult);

    @Operation(summary = "Get a product by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Product",
                                            description = "ProductDTO",
                                            value = "{\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"name\": \"Vino\",\n" +
                                                    "    \"description\": \"Viene de Mendoza\",\n" +
                                                    "    \"imageUrl\": \"botella.jpg\",\n" +
                                                    "    \"price\": 750.50,\n" +
                                                    "    \"stock\": 25,\n" +
                                                    "    \"categoryDTO\": {\n" +
                                                    "        \"id\": 1,\n" +
                                                    "        \"name\": \"Bebidas alcoholicas\",\n" +
                                                    "        \"description\": \"Sale del vino\",\n" +
                                                    "        \"imageUrl\": \"vino.jpg\"\n" +
                                                    "    }\n" +
                                                    "}")
                            }
                    )),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<ProductDTO> getProductById(Long id);

    @Operation(summary = "Get a list of products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products found",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Product",
                                            description = "ProductDTO list",
                                            value = "[\n" +
                                                    "    {\n" +
                                                    "        \"id\": 1,\n" +
                                                    "        \"name\": \"Vino\",\n" +
                                                    "        \"description\": \"Viene de Mendoza\",\n" +
                                                    "        \"imageUrl\": \"botella.jpg\",\n" +
                                                    "        \"price\": 750.50,\n" +
                                                    "        \"stock\": 25,\n" +
                                                    "        \"categoryDTO\": {\n" +
                                                    "            \"id\": 1,\n" +
                                                    "            \"name\": \"Bebidas alcoholicas\",\n" +
                                                    "            \"description\": \"Sale del vino\",\n" +
                                                    "            \"imageUrl\": \"vino.jpg\"\n" +
                                                    "        }\n" +
                                                    "    },\n" +
                                                    "    {\n" +
                                                    "        \"id\": 2,\n" +
                                                    "        \"name\": \"Facturas\",\n" +
                                                    "        \"description\": \"Con crema pastelera\",\n" +
                                                    "        \"imageUrl\": \"mostrador.jpg\",\n" +
                                                    "        \"price\": 95.00,\n" +
                                                    "        \"stock\": 78,\n" +
                                                    "        \"categoryDTO\": {\n" +
                                                    "            \"id\": 2,\n" +
                                                    "            \"name\": \"Panaderia\",\n" +
                                                    "            \"description\": \"Hecho con harinas\",\n" +
                                                    "            \"imageUrl\": \"pan.jpg\"\n" +
                                                    "        }\n" +
                                                    "    }\n" +
                                                    "]")
                            }
                    )),
            @ApiResponse(responseCode = "404", description = "The list is empty",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<List<ProductDTO>> getAllProducts();

    @Operation(summary = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully updated",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Product",
                                            description = "ProductDTO",
                                            value = "{\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"name\": \"Vino\",\n" +
                                                    "    \"description\": \"Viene de Mendoza\",\n" +
                                                    "    \"imageUrl\": \"botella.jpg\",\n" +
                                                    "    \"price\": 750.50,\n" +
                                                    "    \"stock\": 25,\n" +
                                                    "    \"categoryDTO\": {\n" +
                                                    "        \"id\": 1,\n" +
                                                    "        \"name\": \"Bebidas alcoholicas\",\n" +
                                                    "        \"description\": \"Sale del vino\",\n" +
                                                    "        \"imageUrl\": \"vino.jpg\"\n" +
                                                    "    }\n" +
                                                    "}")
                            }
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid field",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO,
                                               BindingResult bindingResult);

    @Operation(summary = "Delete a product by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<Void> deleteProduct(Long id);

}
