package com.codeademy.lt.product.service;

import com.codeademy.lt.product.model.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public void save(ProductDto product);

    public List<ProductDto> getProducts();

    public Page<ProductDto> getProducts(Pageable pageable);

    public ProductDto getProductByUuid(UUID id);

    public void updateProduct(ProductDto product);

    public void deleteProduct(UUID id);
}
