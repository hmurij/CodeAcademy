package com.codeademy.lt.product.repository;

import com.codeademy.lt.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ProductRepository {

    private final Map<UUID, Product> products = new HashMap<>() {
    };

    public void save(Product product) {
        product.setUuid(UUID.randomUUID());
        products.put(product.getUuid(), product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductByUuid(UUID id) {
        return products.get(id);
    }

    public void update(Product product) {
        products.put(product.getUuid(), product);
    }

    public void deleteProduct(UUID id) {
        products.remove(id);
    }
}
