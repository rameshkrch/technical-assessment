package com.example.warehouseservice.warehouse.web;

import com.example.warehouseservice.warehouse.domain.Article;

import java.util.List;

public record LoadArticlesRequest(

        List<Article> articles

) {}
