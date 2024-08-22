package com.example.warehouseservice.warehouse.web;

import com.example.warehouseservice.warehouse.domain.Article;
import com.example.warehouseservice.warehouse.domain.Product;
import com.example.warehouseservice.warehouse.domain.WarehouseService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class WarehouseController {

    private static final Logger log = LoggerFactory.getLogger(WarehouseController.class);

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping("/load/articles")
    public List<Article> loadArticles(@RequestBody @Valid LoadArticlesRequest loadArticlesRequest) {
        log.info("Save articles {}", loadArticlesRequest.articles());
        return warehouseService.saveArticles(loadArticlesRequest.articles());
    }

    @PostMapping("/load/products")
    public List<Product> loadProducts(@RequestBody @Valid LoadProductsRequest loadProductsRequest) {
        log.info("Save products {}", loadProductsRequest.products());
        return warehouseService.saveProducts(loadProductsRequest.products());
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        log.info("Fetching available products");
        return warehouseService.getAvailableProducts();
    }

    @PostMapping("/sell")
    public List<Product> sellProduct(@RequestBody @Valid SellRequest sellRequest) {
        log.info("Processing sell request {}", sellRequest);
        return warehouseService.sellProduct(sellRequest.productName(), sellRequest.quantity());
    }
}
