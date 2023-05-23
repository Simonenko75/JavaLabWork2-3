package com.example.sub.module.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class UserEntityDTO {

    private String login;

    private String password;

}
