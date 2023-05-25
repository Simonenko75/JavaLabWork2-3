package com.example.module.casket.service.repository;

import com.example.module.casket.service.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasketRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategory (String category);

}
