package com.example.module.controller;

import com.example.module.service.ResponseDTO;
import com.example.module.service.UserEntityDTO;
import com.example.module.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public @ResponseBody ResponseDTO login(@RequestBody UserEntityDTO userEntityDTO) {
        return loginService.login(userEntityDTO);
    }

}
