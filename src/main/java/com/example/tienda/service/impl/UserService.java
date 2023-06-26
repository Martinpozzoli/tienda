package com.example.tienda.service.impl;

import com.example.tienda.dto.UserDTO;
import com.example.tienda.exception.NotFoundException;
import com.example.tienda.mapper.UserMapper;
import com.example.tienda.model.UserEntity;
import com.example.tienda.repository.UserRepository;
import com.example.tienda.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("User not found."));
        return userMapper.userEntity2Dto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("Users list is empty");
        }
        List<UserDTO> userDTOS = userMapper.userEntityList2DtoList(users);
        return userDTOS;
    }
}
