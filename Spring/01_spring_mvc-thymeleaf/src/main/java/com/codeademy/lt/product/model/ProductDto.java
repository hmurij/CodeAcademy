package com.codeademy.lt.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ProductDto {
    private UUID uuid;
    private String name;
    private int quantity;
    private BigDecimal price;
    private String description;

}
