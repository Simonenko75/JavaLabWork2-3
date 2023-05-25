package com.example.module.casket.service.service;

import com.example.module.casket.service.model.ProductEntity;
import com.example.module.casket.service.model.ProductEntityDTO;
import com.example.module.casket.service.repository.CasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasketService {

    @Autowired
    public CasketRepository casketRepository;

    public ProductEntityDTO addProduct(ProductEntityDTO productEntityDTO){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productEntityDTO.getName());
        productEntity.setDescription(productEntityDTO.getDescription());
        productEntity.setQuantity(productEntityDTO.getQuantity());
        productEntity.setCategory(productEntityDTO.getCategory());
        casketRepository.save(productEntity);

        ProductEntityDTO productDTO = new ProductEntityDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setQuantity(productEntity.getQuantity());
        productDTO.setCategory(productEntity.getCategory());
        productDTO.setDescription(productEntity.getDescription());
        return productDTO;
    }

    public List<ProductEntityDTO> getProductByCategory(String category) {
        List<ProductEntityDTO> products = new ArrayList<>();
        casketRepository.findByCategory(category).forEach(
                productEntity -> {
                    ProductEntityDTO productDTO = new ProductEntityDTO();
                    productDTO.setId(productEntity.getId());
                    productDTO.setName(productEntity.getName());
                    productDTO.setQuantity(productEntity.getQuantity());
                    productDTO.setCategory(productEntity.getCategory());
                    productDTO.setDescription(productEntity.getDescription());
                    products.add(productDTO);
                }
        );

        return products;
    }

}
