package com.example.warehouseservice.warehouse.domain;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class WarehouseService {

    public Flux<Product> saveProducts(List<Product> products) {
        // TODO: Save batch of products
        return null;
    }

    public Flux<Article> saveArticles(List<Article> articles) {
        // TODO: Save batch of articles
        return null;
    }

    public Flux<Product> getAvailableProducts() {
        // TODO: Find available products
        return null;
    }

    public Flux<Product> sellProduct(String s, Integer quantity) {
        // TODO: Verify inventory

        // TODO: Update inventory
        return null;
    }
}
