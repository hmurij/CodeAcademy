package com.codeademy.lt.product.service;

import com.codeademy.lt.product.model.Product;
import com.codeademy.lt.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public Product getProductByUuid(UUID id) {
        return productRepository.getProductByUuid(id);
    }
}
