package com.codeademy.lt.mapper;

import com.codeademy.lt.product.enitity.Product;
import com.codeademy.lt.product.model.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ProductDto mapToDto(Product product) {
        return new ProductDto(
                product.getUuid(),
                product.getName(),
                product.getQuantityInStock(),
                product.getPrice(),
                product.getDescription()
        );
    }
}
