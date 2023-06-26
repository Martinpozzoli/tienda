package com.example.tienda.mapper;

import com.example.tienda.dto.OrderDTO;
import com.example.tienda.dto.OrderRequestDTO;
import com.example.tienda.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    public Order orderDto2Entity(@NotNull OrderDTO dto){
        Order entity = new Order();
        entity.setId(dto.getId());
        entity.setUserEntity(userMapper.userDto2Entity(dto.getUserDTO()));
        entity.setProducts(productMapper.productDtoList2EntityList(dto.getProducts()));
        return entity;
    }

    public OrderDTO orderEntity2Dto(@NotNull Order entity){
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setUserDTO(userMapper.userEntity2Dto(entity.getUserEntity()));
        dto.setProducts(productMapper.productList2DtoList(entity.getProducts()));
        return dto;
    }

    public Order orderRequestDto2Entity(@NotNull OrderRequestDTO dto){
        Order entity = new Order();
        entity.setProducts(productMapper.productDtoList2EntityList(dto.getProducts()));
        return entity;
    }

    public List<OrderDTO> orderEntityList2DtoList(@NotEmpty List<Order> orders){
        List<OrderDTO> dtos = new ArrayList<>();
        for (Order order : orders) {
            dtos.add(this.orderEntity2Dto(order));
        }
        return dtos;
    }
}
