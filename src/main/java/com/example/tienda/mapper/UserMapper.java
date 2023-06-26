package com.example.tienda.mapper;

import com.example.tienda.auth.dto.UserRequestDto;
import com.example.tienda.auth.dto.UserResponseDto;
import com.example.tienda.dto.UserDTO;
import com.example.tienda.model.UserEntity;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserEntity requestDto2UserEntity(@NotNull UserRequestDto dto){
        UserEntity entity = new UserEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setRoles(dto.getRoles());
        return entity;
    }

    public UserResponseDto userEntity2ResponseDto(@NotNull UserEntity entity){
        UserResponseDto dto = new UserResponseDto();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setRoles(entity.getRoles());
        return dto;
    }

    public List<UserResponseDto> userEntityList2ResponseDtoList(@NotEmpty List<UserEntity> entities){
        List<UserResponseDto> dtos = new ArrayList<>();
        for (UserEntity entity : entities) {
            dtos.add(this.userEntity2ResponseDto(entity));
        }
        return dtos;
    }

    public UserDTO userEntity2Dto(@NotNull UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setRoles(entity.getRoles());
        return dto;
    }

    public UserEntity userDto2Entity(@NotNull UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setRoles(dto.getRoles());
        return entity;
    }

    public List<UserDTO> userEntityList2DtoList(@NotEmpty List<UserEntity> entities){
       List<UserDTO> dtos = new ArrayList<>();
        for (UserEntity entity : entities) {
            dtos.add(this.userEntity2Dto(entity));
        }
        return dtos;
    }
}
