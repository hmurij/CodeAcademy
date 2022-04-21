package com.codeademy.lt.product.service;

import com.codeademy.lt.product.model.Product;
import com.codeademy.lt.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
