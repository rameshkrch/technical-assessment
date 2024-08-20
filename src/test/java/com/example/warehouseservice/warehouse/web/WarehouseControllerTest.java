package com.example.warehouseservice.warehouse.web;

import com.example.warehouseservice.warehouse.domain.Article;
import com.example.warehouseservice.warehouse.domain.Product;
import com.example.warehouseservice.warehouse.domain.ProductPart;
import com.example.warehouseservice.warehouse.domain.WarehouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.mockito.BDDMockito.given;

@WebFluxTest(WarehouseController.class)
class WarehouseControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private WarehouseService warehouseService;

    @Test
    void whenLoadingArticles() {
        var article = new Article(88, "Bella", 5);
        var loadArticlesRequest = new LoadArticlesRequest(List.of(article));

        var expectedArticle = article;
        given(warehouseService.saveArticles(loadArticlesRequest.articles()))
                .willReturn(Flux.just(expectedArticle));

        webClient
                .post()
                .uri("/articles")
                .bodyValue(loadArticlesRequest)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(Article.class)
                .hasSize(1)
                .contains(expectedArticle);
    }

    @Test
    void whenLoadingProducts() {
        var productPart = new ProductPart(1, 33, 3);
        var product = new Product(1, "Tre", 300, List.of(productPart));
        var loadProductsRequest = new LoadProductsRequest(List.of(product));

        var expectedProduct = product;
        given(warehouseService.saveProducts(loadProductsRequest.products()))
                .willReturn(Flux.just(expectedProduct));

        webClient
                .post()
                .uri("/products")
                .bodyValue(loadProductsRequest)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(Product.class)
                .hasSize(1)
                .contains(expectedProduct);
    }

}
