package com.example.tienda.controller;

import com.example.tienda.controller.documentation.OrderControllerDoc;
import com.example.tienda.dto.OrderDTO;
import com.example.tienda.dto.OrderRequestDTO;
import com.example.tienda.exception.BadRequestException;
import com.example.tienda.service.IOrderService;
import com.example.tienda.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Url.ORDERS)
public class OrderController implements OrderControllerDoc {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private HttpServletRequest request;

    @Override
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult);
        }
        OrderDTO orderDTO = orderService.createOrder(orderRequestDTO, request.getHeader("Authorization"));
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

}
