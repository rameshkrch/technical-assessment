package com.example.warehouseservice.warehouse.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Product> saveProducts(List<Product> products) {
        connectAllProductParts(products);
        return productRepository.saveAll(products);
    }

    private void connectAllProductParts(List<Product> products) {
        for (Product product : products) {
            connectProductParts(product);
        }
    }

    private void connectProductParts(Product product) {
        for (ProductPart productPart : product.getParts()) {
            productPart.setProduct(product);
        }
    }

    public List<Article> saveArticles(List<Article> articles) {
        return articleRepository.saveAll(articles);
    }

    public List<Product> getAvailableProducts() {
        // TODO: Find available products
        return null;
    }

    public List<Product> sellProduct(String s, Integer quantity) {
        // TODO: Verify inventory

        // TODO: Update inventory
        return null;
    }
}
