package com.example.module.order.service.controller;

import com.example.module.order.service.model.OrderEntityDTO;
import com.example.module.order.service.model.ResponseDTO;
import com.example.module.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public @ResponseBody OrderEntityDTO orderAdd(@RequestBody OrderEntityDTO orderEntityDTO) {
        return orderService.orderAdd(orderEntityDTO);
    }

    @PostMapping("/user/login")
    public @ResponseBody ResponseDTO getUserByLogin(@RequestParam String login) {
        return orderService.getUserIdByLogin(login);
    }

    @PostMapping("/user/orders")
    public @ResponseBody ResponseDTO getUserByOrder(@RequestParam String orders) {
        return orderService.getUserByOrder(orders);
    }

}
