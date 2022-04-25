package com.codeademy.lt.product.service;

import com.codeademy.lt.product.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public void save(Product product);

    public List<Product> getProducts();

    public Product getProductByUuid(UUID id);

    public void updateProduct(Product product);

    public void deleteProduct(UUID id);
}
