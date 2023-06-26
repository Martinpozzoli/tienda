package com.example.tienda.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private long id;

    private UserDTO userDTO;

    private List<ProductDTO> products;
}
