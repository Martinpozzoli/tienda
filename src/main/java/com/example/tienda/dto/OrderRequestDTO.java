package com.example.tienda.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequestDTO {

    @NotEmpty(message = "Product list cannot be null")
    private List<ProductDTO> products;

}
