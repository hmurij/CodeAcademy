package com.codeademy.lt.product.repository;

import com.codeademy.lt.product.model.ProductDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
//@RequiredArgsConstructor
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    private final Map<UUID, ProductDto> products = new HashMap<>();

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(ProductDto product) {
        product.setUuid(UUID.randomUUID());
        products.put(product.getUuid(), product);
    }

    public List<ProductDto> getProducts() {
        return jdbcTemplate.query("select * from product",
                new RowMapper<ProductDto>() {
                    @Override
                    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                        return ProductDto.builder()
                                .uuid(UUID.fromString(rs.getString("product_id")))
                                .name(rs.getString("name"))
                                .price(rs.getBigDecimal("price"))
                                .quantity(rs.getInt("quantity_in_stock"))
                                .description(rs.getString("description"))
                                .build();
                    }
                });
//        return new ArrayList<>(products.values());
    }

    public ProductDto getProductByUuid(UUID id) {
        return products.get(id);
    }

    public void update(ProductDto product) {
        products.put(product.getUuid(), product);
    }

    public void deleteProduct(UUID id) {
        products.remove(id);
    }
}
