package com.example.module.order.service.controller;

import com.example.module.order.service.model.OrderEntity;
import com.example.module.order.service.model.OrderEntityDTO;
import com.example.module.order.service.model.ResponseDTO;
import com.example.module.order.service.model.UserEntityDTO;
import com.example.module.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public @ResponseBody OrderEntityDTO orderAdd(@RequestBody OrderEntityDTO orderEntityDTO) {
        return orderService.orderAdd(orderEntityDTO);
    }

    @PostMapping("/user")
    public @ResponseBody ResponseDTO getUserByOrder(@RequestBody UserEntityDTO userEntityDTO) {
        return orderService.getUserByOrder(userEntityDTO);
    }

}
