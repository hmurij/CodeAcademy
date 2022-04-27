package com.codeademy.lt.product.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id")
    private UUID uuid;
    private String name;
    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;
    private BigDecimal price;
    private String description;

    public Product(UUID uuid, String name, Integer quantityInStock, BigDecimal price, String description) {
        this.uuid = uuid;
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.description = description;
    }
}
