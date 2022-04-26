package com.codeademy.lt.product.service;

import com.codeademy.lt.mapper.Mapper;
import com.codeademy.lt.product.enitity.Product;
import com.codeademy.lt.product.model.ProductDto;
import com.codeademy.lt.product.repository.ProductRepository;
import com.codeademy.lt.product.repository.ProductRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class ProductServiceImplJpa implements ProductService {

    private ProductRepositoryJpa productRepositoryJpa;
    private Mapper mapper;

    private final ProductRepository productRepository;

    public void save(ProductDto product) {
        productRepositoryJpa.save(new Product(
                UUID.randomUUID(),
                product.getName(),
                product.getQuantity(),
                product.getPrice(),
                product.getDescription()
        ));
        productRepository.save(product);
    }

    public List<ProductDto> getProducts() {
        return productRepositoryJpa.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
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
