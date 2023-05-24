package com.example.sub.module.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    public AmqpTemplate template;

    @PostMapping("/send")
    public @ResponseBody String send(@RequestBody String message) {
        log.info("Send to myTestQueue");
        template.convertAndSend("myTestQueue", message);
        return "Emit to myTestQueue";
    }

}
