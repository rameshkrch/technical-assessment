package com.example.warehouseservice.warehouse.web;

import com.example.warehouseservice.warehouse.domain.Article;
import com.example.warehouseservice.warehouse.domain.Product;
import com.example.warehouseservice.warehouse.domain.ProductPart;
import com.example.warehouseservice.warehouse.domain.WarehouseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WarehouseController.class)
class WarehouseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WarehouseService warehouseService;

    @Test
    void whenLoadingArticles() throws Exception {
        var article = new Article(88, "Bella", 5);
        var loadArticlesRequest = new LoadArticlesRequest(List.of(article));

        var expectedArticle = article;
        when(warehouseService.saveArticles(any())).thenReturn(List.of(expectedArticle));

        mockMvc
                .perform(post("/articles")
                        .content(asJson(loadArticlesRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].art_id").value(expectedArticle.getId()))
                .andExpect(jsonPath("$[0].name").value(expectedArticle.getName()))
                .andExpect(jsonPath("$[0].stock").value(expectedArticle.getQuantity()))
                ;
    }

    @Test
    void whenLoadingProducts() throws Exception {
        var article = new Article(88, "Bella", 5);
        var product = new Product(1, "Tre", 300, new ArrayList<>());
        var productPart = new ProductPart(0, product, article.getId(), 3);
        product.getParts().add(productPart);

        var loadProductsRequest = new LoadProductsRequest(List.of(product));
        var expectedProduct = product;

        when(warehouseService.saveProducts(any())).thenReturn(List.of(expectedProduct));

        mockMvc
                .perform(post("/products")
                        .content(asJson(loadProductsRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].name").value(expectedProduct.getName()))
                .andExpect(jsonPath("$[0].price").value(expectedProduct.getPrice()));
    }

    public static String asJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
