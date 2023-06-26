package com.example.tienda.service;

import com.example.tienda.dto.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();
}
