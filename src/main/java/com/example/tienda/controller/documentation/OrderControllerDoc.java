package com.example.tienda.controller.documentation;

import com.example.tienda.dto.OrderDTO;
import com.example.tienda.dto.OrderRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface OrderControllerDoc {

    @Operation(summary = "Create a new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order successfully created",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Order",
                                            description = "OrderDTO",
                                            value = "{\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"userDTO\": {\n" +
                                                    "        \"id\": 2,\n" +
                                                    "        \"firstName\": \"Martin\",\n" +
                                                    "        \"lastName\": \"Pozzoli\",\n" +
                                                    "        \"email\": \"martinpozzoli@gmail.com\",\n" +
                                                    "        \"roles\": [\n" +
                                                    "            {\n" +
                                                    "                \"id\": 1,\n" +
                                                    "                \"name\": \"ROLE_ADMIN\"\n" +
                                                    "            }\n" +
                                                    "        ]\n" +
                                                    "    },\n" +
                                                    "    \"products\": [\n" +
                                                    "        {\n" +
                                                    "            \"id\": 1,\n" +
                                                    "            \"name\": \"Vino\",\n" +
                                                    "            \"description\": \"Viene de la uva y se fermenta\",\n" +
                                                    "            \"imageUrl\": \"vino.jpg\",\n" +
                                                    "            \"price\": 800.25,\n" +
                                                    "            \"stock\": 54,\n" +
                                                    "            \"categoryDTO\": {\n" +
                                                    "                \"id\": 3,\n" +
                                                    "                \"name\": \"Bebidas alcoholicas\",\n" +
                                                    "                \"description\": \"Sale del vino\",\n" +
                                                    "                \"imageUrl\": \"vino.jpg\"\n" +
                                                    "            }\n" +
                                                    "        },\n" +
                                                    "        {\n" +
                                                    "            \"id\": 2,\n" +
                                                    "            \"name\": \"Facturas\",\n" +
                                                    "            \"description\": \"Con crema pastelera\",\n" +
                                                    "            \"imageUrl\": \"mostrador.jpg\",\n" +
                                                    "            \"price\": 95.00,\n" +
                                                    "            \"stock\": 78,\n" +
                                                    "            \"categoryDTO\": {\n" +
                                                    "                \"id\": 2,\n" +
                                                    "                \"name\": \"Panaderia\",\n" +
                                                    "                \"description\": \"Hecho con harinas\",\n" +
                                                    "                \"imageUrl\": \"pan.jpg\"\n" +
                                                    "            }\n" +
                                                    "        }\n" +
                                                    "    ]\n" +
                                                    "}")
                            }
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid field",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<OrderDTO> createOrder(OrderRequestDTO orderRequestDTO,
                                         BindingResult bindingResult);

    @Operation(summary = "Get an order by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Order",
                                            description = "OrderDTO",
                                            value = "{\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"userDTO\": {\n" +
                                                    "        \"id\": 2,\n" +
                                                    "        \"firstName\": \"Martin\",\n" +
                                                    "        \"lastName\": \"Pozzoli\",\n" +
                                                    "        \"email\": \"martinpozzoli@gmail.com\",\n" +
                                                    "        \"roles\": [\n" +
                                                    "            {\n" +
                                                    "                \"id\": 1,\n" +
                                                    "                \"name\": \"ROLE_ADMIN\"\n" +
                                                    "            }\n" +
                                                    "        ]\n" +
                                                    "    },\n" +
                                                    "    \"products\": [\n" +
                                                    "        {\n" +
                                                    "            \"id\": 1,\n" +
                                                    "            \"name\": \"Vino\",\n" +
                                                    "            \"description\": \"Viene de la uva y se fermenta\",\n" +
                                                    "            \"imageUrl\": \"vino.jpg\",\n" +
                                                    "            \"price\": 800.25,\n" +
                                                    "            \"stock\": 54,\n" +
                                                    "            \"categoryDTO\": {\n" +
                                                    "                \"id\": 3,\n" +
                                                    "                \"name\": \"Bebidas alcoholicas\",\n" +
                                                    "                \"description\": \"Sale del vino\",\n" +
                                                    "                \"imageUrl\": \"vino.jpg\"\n" +
                                                    "            }\n" +
                                                    "        },\n" +
                                                    "        {\n" +
                                                    "            \"id\": 2,\n" +
                                                    "            \"name\": \"Facturas\",\n" +
                                                    "            \"description\": \"Con crema pastelera\",\n" +
                                                    "            \"imageUrl\": \"mostrador.jpg\",\n" +
                                                    "            \"price\": 95.00,\n" +
                                                    "            \"stock\": 78,\n" +
                                                    "            \"categoryDTO\": {\n" +
                                                    "                \"id\": 2,\n" +
                                                    "                \"name\": \"Panaderia\",\n" +
                                                    "                \"description\": \"Hecho con harinas\",\n" +
                                                    "                \"imageUrl\": \"pan.jpg\"\n" +
                                                    "            }\n" +
                                                    "        }\n" +
                                                    "    ]\n" +
                                                    "}")
                            }
                    )),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<OrderDTO> getOrderById(Long id);

    @Operation(summary = "Get a list of orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders found",
                    content = @Content(
                            examples = {
                                    @ExampleObject(
                                            name = "Example1",
                                            summary = "Order",
                                            description = "OrderDTO list",
                                            value = "[\n" +
                                                    "    {\n" +
                                                    "        \"id\": 1,\n" +
                                                    "        \"userDTO\": {\n" +
                                                    "            \"id\": 2,\n" +
                                                    "            \"firstName\": \"Martin\",\n" +
                                                    "            \"lastName\": \"Pozzoli\",\n" +
                                                    "            \"email\": \"martinpozzoli@gmail.com\",\n" +
                                                    "            \"roles\": [\n" +
                                                    "                {\n" +
                                                    "                    \"id\": 1,\n" +
                                                    "                    \"name\": \"ROLE_ADMIN\"\n" +
                                                    "                }\n" +
                                                    "            ]\n" +
                                                    "        },\n" +
                                                    "        \"products\": [\n" +
                                                    "            {\n" +
                                                    "                \"id\": 1,\n" +
                                                    "                \"name\": \"Vino\",\n" +
                                                    "                \"description\": \"Viene de Mendoza\",\n" +
                                                    "                \"imageUrl\": \"botella.jpg\",\n" +
                                                    "                \"price\": 750.50,\n" +
                                                    "                \"stock\": 25,\n" +
                                                    "                \"categoryDTO\": {\n" +
                                                    "                    \"id\": 1,\n" +
                                                    "                    \"name\": \"Bebidas alcoholicas\",\n" +
                                                    "                    \"description\": \"Sale del vino\",\n" +
                                                    "                    \"imageUrl\": \"vino.jpg\"\n" +
                                                    "                }\n" +
                                                    "            },\n" +
                                                    "            {\n" +
                                                    "                \"id\": 2,\n" +
                                                    "                \"name\": \"Facturas\",\n" +
                                                    "                \"description\": \"Con crema pastelera\",\n" +
                                                    "                \"imageUrl\": \"mostrador.jpg\",\n" +
                                                    "                \"price\": 95.00,\n" +
                                                    "                \"stock\": 78,\n" +
                                                    "                \"categoryDTO\": {\n" +
                                                    "                    \"id\": 2,\n" +
                                                    "                    \"name\": \"Panaderia\",\n" +
                                                    "                    \"description\": \"Hecho con harinas\",\n" +
                                                    "                    \"imageUrl\": \"pan.jpg\"\n" +
                                                    "                }\n" +
                                                    "            }\n" +
                                                    "        ]\n" +
                                                    "    },\n" +
                                                    "    {\n" +
                                                    "        \"id\": 2,\n" +
                                                    "        \"userDTO\": {\n" +
                                                    "            \"id\": 1,\n" +
                                                    "            \"firstName\": \"Jose\",\n" +
                                                    "            \"lastName\": \"Perez\",\n" +
                                                    "            \"email\": \"josep@gmail.com\",\n" +
                                                    "            \"roles\": [\n" +
                                                    "                {\n" +
                                                    "                    \"id\": 1,\n" +
                                                    "                    \"name\": \"ROLE_ADMIN\"\n" +
                                                    "                }\n" +
                                                    "            ]\n" +
                                                    "        },\n" +
                                                    "        \"products\": [\n" +
                                                    "            {\n" +
                                                    "                \"id\": 1,\n" +
                                                    "                \"name\": \"Vino\",\n" +
                                                    "                \"description\": \"Viene de Mendoza\",\n" +
                                                    "                \"imageUrl\": \"botella.jpg\",\n" +
                                                    "                \"price\": 750.50,\n" +
                                                    "                \"stock\": 25,\n" +
                                                    "                \"categoryDTO\": {\n" +
                                                    "                    \"id\": 1,\n" +
                                                    "                    \"name\": \"Bebidas alcoholicas\",\n" +
                                                    "                    \"description\": \"Sale del vino\",\n" +
                                                    "                    \"imageUrl\": \"vino.jpg\"\n" +
                                                    "                }\n" +
                                                    "            }\n" +
                                                    "        ]\n" +
                                                    "    }\n" +
                                                    "]")
                            }
                    )),
            @ApiResponse(responseCode = "404", description = "The list is empty",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Invalid token or accessing with invalid role",
                    content = @Content)})
    ResponseEntity<List<OrderDTO>> getAllOrders();
}
