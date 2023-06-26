package com.example.tienda.auth.dto;

import com.example.tienda.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {

    private String firstName;

    private String lastName;

    private String email;

    private List<Role> roles;
}
