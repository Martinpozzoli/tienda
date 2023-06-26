package com.example.tienda.controller.documentation;

import com.example.tienda.auth.dto.AuthenticationRequest;
import com.example.tienda.auth.dto.AuthenticationResponse;
import com.example.tienda.auth.dto.UserRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface AuthControllerDoc {

    @Operation(summary = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully created",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "User",
                                            description = "JWT token",
                                            value = "{\"jwt\": \"ey...lhdCI6\"}")
                            }
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid data request",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Conflict Exception - There is already an account with this email",
                    content = @Content)})
    ResponseEntity<AuthenticationResponse> userRegistration(UserRequestDto userRequestDto, BindingResult bindingResult) throws Exception;


    @Operation(summary = "Login to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User is logged, returns a token",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "User",
                                            description = "JWT token",
                                            value = "{\"jwt\": \"ey...lhdCI6\"}")
                            }
                    )),
            @ApiResponse(responseCode = "403", description = "Incorrect username or password",
                    content = @Content)})
    ResponseEntity<AuthenticationResponse> signIn(AuthenticationRequest authRequest);

}
