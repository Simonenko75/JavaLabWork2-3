package com.example.sub.module.controller;

import com.example.sub.module.model.UserEntityDTO;
import com.example.sub.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public @ResponseBody void addUser(@RequestBody UserEntityDTO userEntityDTO) {
        userService.addUser(userEntityDTO);
    }

    @GetMapping("/get")
    public @ResponseBody UserEntityDTO getUserByLogin(@RequestParam String login) {
        return userService.getUserByLogin(login);
    }

}
