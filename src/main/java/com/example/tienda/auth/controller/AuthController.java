package com.example.tienda.auth.controller;

import com.example.tienda.auth.dto.AuthenticationRequest;
import com.example.tienda.auth.dto.AuthenticationResponse;
import com.example.tienda.auth.dto.UserRequestDto;
import com.example.tienda.auth.dto.UserResponseDto;
import com.example.tienda.auth.service.JwtUtils;
import com.example.tienda.auth.service.UserDetailsCustomService;
import com.example.tienda.controller.documentation.AuthControllerDoc;
import com.example.tienda.exception.BadRequestException;
import com.example.tienda.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Url.AUTH)
public class AuthController implements AuthControllerDoc {

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> userRegistration(@Valid @RequestBody UserRequestDto userRequestDto, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult);
        }
        UserResponseDto userResponseDto = userDetailsCustomService.register(userRequestDto);
        AuthenticationRequest authRequest = new AuthenticationRequest(userRequestDto.getEmail(), userRequestDto.getPassword());
        AuthenticationResponse authResponse = userDetailsCustomService.login(authRequest);
        return ResponseEntity.ok().body(authResponse);
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody AuthenticationRequest authRequest){
        AuthenticationResponse authResponse = userDetailsCustomService.login(authRequest);
        return ResponseEntity.ok().body(authResponse);
    }
}
