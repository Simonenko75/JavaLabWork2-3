package com.example.module.order.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntityDTO {

    private Long id;

    private String login;

    private String password;

    private String orders;

}
