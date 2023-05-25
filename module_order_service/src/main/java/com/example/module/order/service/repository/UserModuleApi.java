package com.example.module.order.service.repository;

import com.example.module.order.service.model.UserEntityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(name = "User", url = "localhost:9999")
public interface UserModuleApi {

    @GetMapping("/user/get")
    @ResponseBody UserEntityDTO getUserByOrder(@RequestParam String orders);

}
