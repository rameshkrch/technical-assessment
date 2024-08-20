package com.example.warehouseservice.warehouse.domain;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProductRepository extends R2dbcRepository<Product, Integer> {
}
