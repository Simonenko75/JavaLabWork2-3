package com.example.module.casket.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEntityDTO {

    private Long id;

    private String name;

    private int quantity;

    private String category;

    private String description;

}
