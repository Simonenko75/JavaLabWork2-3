package com.example.module.user.service.controller;

import com.example.module.user.service.model.UserEntity;
import com.example.module.user.service.model.UserEntityDTO;
import com.example.module.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public @ResponseBody UserEntity addUser(@RequestBody UserEntityDTO userEntityDTO) {
        return userService.addUser(userEntityDTO);
    }

    @GetMapping("/get/login")
    public @ResponseBody UserEntityDTO getUserByLogin(@RequestParam String login) {
        return userService.getUserByLogin(login);
    }

    @GetMapping("/get/orders")
    public @ResponseBody UserEntityDTO getUserByOrders(@RequestParam String orders) {
        return userService.getUserByOrders(orders);
    }

}
