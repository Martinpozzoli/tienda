package com.example.tienda.service;

import com.example.tienda.dto.OrderDTO;
import com.example.tienda.dto.OrderRequestDTO;

import java.util.List;

public interface IOrderService {

    OrderDTO createOrder(OrderRequestDTO orderRequestDTO, String token);

    OrderDTO getOrderById(Long id);

    List<OrderDTO> getAllOrders();

    OrderDTO updateOrder(OrderDTO orderDTO);

}
