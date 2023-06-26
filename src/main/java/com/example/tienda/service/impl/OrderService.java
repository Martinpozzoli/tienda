package com.example.tienda.service.impl;

import com.example.tienda.auth.service.JwtUtils;
import com.example.tienda.dto.OrderDTO;
import com.example.tienda.dto.OrderRequestDTO;
import com.example.tienda.exception.NotFoundException;
import com.example.tienda.mapper.OrderMapper;
import com.example.tienda.model.Order;
import com.example.tienda.model.UserEntity;
import com.example.tienda.repository.OrderRepository;
import com.example.tienda.repository.UserRepository;
import com.example.tienda.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderDTO createOrder(OrderRequestDTO orderRequestDTO, String token) {
        String jwt = token.substring(7);
        String username = jwtUtils.extractUsername(jwt);
        UserEntity user = userRepository.findByEmail(username)
                .orElseThrow(()-> new NotFoundException("User not found"));

        Order newOrder = orderMapper.orderRequestDto2Entity(orderRequestDTO);
        newOrder.setUserEntity(user);
        Order savedOrder = orderRepository.save(newOrder);
        return orderMapper.orderEntity2Dto(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Order not found"));
        return orderMapper.orderEntity2Dto(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()) {
            throw new NotFoundException("Orders list is empty");
        }
        return orderMapper.orderEntityList2DtoList(orders);
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        return null;
    }
}
