package com.example.warehouseservice.warehouse.domain;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends R2dbcRepository<Article, Integer> {
}
