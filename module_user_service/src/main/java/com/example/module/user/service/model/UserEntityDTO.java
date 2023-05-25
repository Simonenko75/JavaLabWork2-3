package com.example.module.user.service.model;

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
