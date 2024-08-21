package com.example.warehouseservice.warehouse.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPartRepository extends JpaRepository<ProductPart, Integer> {
}
