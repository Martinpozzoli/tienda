package com.example.tienda.controller.documentation;

import com.example.tienda.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserControllerDoc {

    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "User",
                                            description = "UserDTO",
                                            value = "{\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"firstName\": \"Martin\",\n" +
                                                    "    \"lastName\": \"Pozzoli\",\n" +
                                                    "    \"email\": \"martinozzoli@gmai.com\",\n" +
                                                    "    \"roles\": [\n" +
                                                    "        {\n" +
                                                    "            \"id\": 2,\n" +
                                                    "            \"name\": \"ROLE_USER\"\n" +
                                                    "        }\n" +
                                                    "    ]\n" +
                                                    "}")
                            }
                    )),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<UserDTO> getUserById(Long id);

    @Operation(summary = "Get a list of users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "User",
                                            description = "UserDTO list",
                                            value = "[\n" +
                                                    "    {\n" +
                                                    "        \"id\": 1,\n" +
                                                    "        \"firstName\": \"Martin\",\n" +
                                                    "        \"lastName\": \"Pozzoli\",\n" +
                                                    "        \"email\": \"martinozzoli@gmai.com\",\n" +
                                                    "        \"roles\": [\n" +
                                                    "            {\n" +
                                                    "                \"id\": 2,\n" +
                                                    "                \"name\": \"ROLE_USER\"\n" +
                                                    "            }\n" +
                                                    "        ]\n" +
                                                    "    },\n" +
                                                    "    {\n" +
                                                    "        \"id\": 2,\n" +
                                                    "        \"firstName\": \"Jose\",\n" +
                                                    "        \"lastName\": \"Perez\",\n" +
                                                    "        \"email\": \"josep@gmail.com\",\n" +
                                                    "        \"roles\": [\n" +
                                                    "            {\n" +
                                                    "                \"id\": 1,\n" +
                                                    "                \"name\": \"ROLE_ADMIN\"\n" +
                                                    "            }\n" +
                                                    "        ]\n" +
                                                    "    }\n" +
                                                    "]")
                            }
                    )),
            @ApiResponse(responseCode = "404", description = "The list is empty",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<List<UserDTO>> getAllUsers();
}
