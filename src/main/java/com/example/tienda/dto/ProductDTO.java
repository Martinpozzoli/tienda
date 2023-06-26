package com.example.tienda.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    @NotNull(message = "Id cannot be null")
    private long id;

    private String name;

    private String description;

    private String imageUrl;

    private BigDecimal price;

    private int stock;

    private CategoryDTO categoryDTO;

}
