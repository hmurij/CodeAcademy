package com.codeademy.lt.product.service;

import com.codeademy.lt.product.model.ProductDto;
import com.codeademy.lt.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public void save(ProductDto product) {
        productRepository.save(product);
    }

    public List<ProductDto> getProducts() {
        return productRepository.getProducts();
    }

    public void updateProduct(ProductDto product) {
        productRepository.update(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public ProductDto getProductByUuid(UUID id) {
        return productRepository.getProductByUuid(id);
    }
}
