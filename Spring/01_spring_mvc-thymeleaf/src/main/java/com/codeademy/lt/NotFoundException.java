package com.codeademy.lt;

import java.util.UUID;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private final UUID productId;
    private int myInt;
    private String str;

    public NotFoundException(UUID productId) {
        super();
        this.productId = productId;
    }

    public UUID getProductId() {
        return productId;
    }
}
