package com.codeademy.lt.product.service;

import com.codeademy.lt.mapper.Mapper;
import com.codeademy.lt.product.enitity.Product;
import com.codeademy.lt.product.model.ProductDto;
import com.codeademy.lt.product.repository.ProductRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class ProductServiceImplJpa implements ProductService {

    private ProductRepositoryJpa productRepositoryJpa;
    private Mapper mapper;

    @Transactional
    public void save(ProductDto product) {
        productRepositoryJpa.save(new Product(
                UUID.randomUUID(),
                product.getName(),
                product.getQuantity(),
                product.getPrice(),
                product.getDescription()
        ));
    }

    @Transactional
    public List<ProductDto> getProducts() {
        return productRepositoryJpa.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Page<ProductDto> getProducts(Pageable pageable) {
        return productRepositoryJpa.findAll(pageable)
                .map(mapper::mapToDto);
    }

    @Transactional
    public void updateProduct(ProductDto product) {
        productRepositoryJpa.save(new Product(
                productRepositoryJpa.findByUuid(product.getUuid()).getId(),
                UUID.randomUUID(),
                product.getName(),
                product.getQuantity(),
                product.getPrice(),
                product.getDescription()
        ));
    }

    @Transactional
    public void deleteProduct(UUID id) {
        productRepositoryJpa.deleteById(
                productRepositoryJpa.findByUuid(id).getId()
        );
    }

    @Transactional
    public ProductDto getProductByUuid(UUID id) {
        return mapper.mapToDto(productRepositoryJpa.findByUuid(id));
//        return productRepositoryJpa.findByUuid(id).map(mapper::mapToDto)
//                .orElseGet(ProductDto::new);
    }

}
