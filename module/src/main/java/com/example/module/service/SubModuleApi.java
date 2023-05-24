package com.example.module.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(name = "user", url = "localhost:8888")
public interface SubModuleApi {

    @GetMapping("/user/get")
    @ResponseBody UserEntityDTO getUserByLogin(@RequestParam String login);

}
