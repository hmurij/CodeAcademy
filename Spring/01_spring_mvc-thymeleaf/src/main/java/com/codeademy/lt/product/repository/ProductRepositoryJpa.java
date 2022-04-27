package com.codeademy.lt.product.repository;

import com.codeademy.lt.product.enitity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepositoryJpa extends JpaRepository<Product, Long> {
    Product findByUuid(UUID uuid);
}
