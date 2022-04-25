package com.codeademy.lt.config;

import com.codeademy.lt.product.model.Product;
import com.codeademy.lt.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class MockDataConfig {
    private final int MAX_COUNT = 10;

    private final ProductRepository productRepository;

    @Bean
    public void initProducts() {
        var count = 0;

        while (MAX_COUNT >= count) {
            productRepository.save(
                    Product.builder()
                            .name("Name " + count)
                            .price(BigDecimal.valueOf(count * 10))
                            .quantity(count * 2)
                            .description("No comments")
                            .build()
            );
            count++;
        }
        log.atDebug().log("====== initProduct initialized");
    }

}
