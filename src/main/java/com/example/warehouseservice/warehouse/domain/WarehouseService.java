package com.example.warehouseservice.warehouse.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ProductRepository productRepository;

    public Flux<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Flux<Article> saveArticles(List<Article> articles) {
        return articleRepository.saveAll(articles);
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
