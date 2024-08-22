package com.example.warehouseservice.warehouse.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDao, Integer> {
}
