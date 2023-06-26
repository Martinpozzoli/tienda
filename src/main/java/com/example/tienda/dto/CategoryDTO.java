package com.example.tienda.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryDTO {

    @NotNull(message = "Id cannot be null")
    private long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private String description;

    private String imageUrl;

}
