package com.example.Springdatasources.product.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Springdatasources.product.ProductEntity;

@Repository
public interface ProductRepositry  extends JpaRepository<ProductEntity, Long>{

}
