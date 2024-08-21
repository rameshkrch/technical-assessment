package com.example.warehouseservice.warehouse.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class ArticleRepositoryJpaTest {

    @Autowired
    private ArticleRepository articleRepository;

    // static, all tests share this postgres container
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    );

    @Test
    void findAllArticles() {
        var article1 = new Article(1, "leg", 12);
        var article2 = new Article(2, "screw", 17);
        articleRepository.saveAll(List.of(article1, article2));

        var actualArticle1 = articleRepository.findById(1);
        var actualArticle2 = articleRepository.findById(2);

        assertEquals(article1, actualArticle1.get());
        assertEquals(article2, actualArticle2.get());
    }
}
