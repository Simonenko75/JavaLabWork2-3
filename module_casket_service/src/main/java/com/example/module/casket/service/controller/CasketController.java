package com.example.module.casket.service.controller;

import com.example.module.casket.service.model.ProductEntityDTO;
import com.example.module.casket.service.service.CasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class CasketController {

    @Autowired
    private CasketService casketService;

    @PostMapping("/add")
    public @ResponseBody ProductEntityDTO addProduct(@RequestBody ProductEntityDTO productEntityDTO) {
        return casketService.addProduct(productEntityDTO);
    }

    @GetMapping("/get")
    public @ResponseBody List<ProductEntityDTO> getProductsByCategory(@RequestParam String category){
        return casketService.getProductByCategory(category);
    }

}
