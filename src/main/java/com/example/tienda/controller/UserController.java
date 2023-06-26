package com.example.tienda.controller;

import com.example.tienda.controller.documentation.UserControllerDoc;
import com.example.tienda.dto.UserDTO;
import com.example.tienda.service.IUserService;
import com.example.tienda.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Url.USERS)
public class UserController implements UserControllerDoc {

    @Autowired
    private IUserService userService;

    @Override
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
}
