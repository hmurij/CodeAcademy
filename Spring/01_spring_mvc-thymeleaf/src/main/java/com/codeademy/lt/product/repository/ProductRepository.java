package com.codeademy.lt.product.repository;

import com.codeademy.lt.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public void save(Product product) {
        products.add(product);
    }
}
