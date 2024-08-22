package com.example.warehouseservice.warehouse.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class WarehouseServiceTest {

    // static, all tests share this postgres container
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    );

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void whenGetAvailableProducts() {
        loadArticles();
        loadProducts();

        var salesProducts = warehouseService.getAvailableProducts();

        var chairCount = salesProducts.stream()
                .filter(sp -> sp.name().equals("Dining Chair"))
                .map(SalesProduct::quantity)
                .toList()
                .get(0);

        var tableCount = salesProducts.stream()
                .filter(sp -> sp.name().equals("Dinning Table"))
                .map(SalesProduct::quantity)
                .toList()
                .get(0);

        assertEquals(2, chairCount);
        assertEquals(1, tableCount);
    }

    private void loadArticles() {
        var articles = new ArrayList<Article>();
        articles.add(new Article(1, "leg", 12));
        articles.add(new Article(2, "screw", 17));
        articles.add(new Article(3, "leg", 2));
        articles.add(new Article(4, "table top", 1));
        articleRepository.saveAll(articles);
    }

    private void loadProducts() {
        var product1 = new ProductDao("Dining Chair", 20);
        var product2 = new ProductDao("Dinning Table", 50);

        var productParts1 = new ArrayList<ProductPartDao>();
        productParts1.add(new ProductPartDao(product1, new Article(1), 4));
        productParts1.add(new ProductPartDao(product1, new Article(2), 8));
        productParts1.add(new ProductPartDao(product1, new Article(3), 1));

        var productParts2 = new ArrayList<ProductPartDao>();
        productParts2.add(new ProductPartDao(product2, new Article(1), 4));
        productParts2.add(new ProductPartDao(product2, new Article(2), 8));
        productParts2.add(new ProductPartDao(product2, new Article(4), 1));

        product1.setParts(productParts1);
        product2.setParts(productParts2);

        var products = new ArrayList<ProductDao>();
        products.add(product1);
        products.add(product2);

        productRepository.saveAll(products);
    }
}
