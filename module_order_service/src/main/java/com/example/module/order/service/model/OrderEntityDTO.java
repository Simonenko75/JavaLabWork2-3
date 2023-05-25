package com.example.module.order.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEntityDTO {

    private Long id;

    private String name;

    private String titles;

    private int quantity;

}
