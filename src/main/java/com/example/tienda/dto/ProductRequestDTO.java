package com.example.tienda.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDTO {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private String description;

    private String imageUrl;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    @NotNull(message = "Stock cannot be null")
    private int stock;

    @NotNull(message = "Category cannot be null")
    private CategoryDTO categoryDTO;

}
