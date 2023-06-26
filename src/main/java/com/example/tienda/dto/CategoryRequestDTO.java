package com.example.tienda.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CategoryRequestDTO {

        @NotEmpty(message = "Name cannot be empty")
        private String name;

        private String description;

        private String imageUrl;

}
