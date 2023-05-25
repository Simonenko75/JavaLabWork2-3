package com.example.module.order.service.controller;

import com.example.module.order.service.model.OrderEntityDTO;
import com.example.module.order.service.model.ResponseDTO;
import com.example.module.order.service.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Add user's orders"})
@SwaggerDefinition(tags = {@Tag(name = "Add user's orders", description = "Add new orders to table and find user by login and id")})
@Controller
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private OrderService orderService;

    @Operation(summary = "Add new order to table 'orders'")
    @ApiResponse(
            code = 200,
            message = "New user's order",
            response = OrderEntityDTO.class
    )
    @PostMapping("/add")
    public @ResponseBody OrderEntityDTO orderAdd(@RequestBody OrderEntityDTO orderEntityDTO) {
        return orderService.orderAdd(orderEntityDTO);
    }

    @Operation(summary = "Find user id by login in table 'users'")
    @ApiResponse(
            code = 200,
            message = "User id from table 'users'",
            response = ResponseDTO.class
    )
    @PostMapping("/user/login")
    public @ResponseBody ResponseDTO getUserByLogin(@RequestParam String login) {
        return orderService.getUserIdByLogin(login);
    }

    @Operation(summary = "Find user login by orders in table 'users'")
    @ApiResponse(
            code = 200,
            message = "User login from table 'users'",
            response = ResponseDTO.class
    )
    @PostMapping("/user/orders")
    public @ResponseBody ResponseDTO getUserByOrder(@RequestParam String orders) {
        return orderService.getUserByOrder(orders);
    }

}
