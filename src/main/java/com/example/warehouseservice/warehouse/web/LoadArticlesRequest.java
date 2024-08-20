package com.example.warehouseservice.warehouse.web;

import com.example.warehouseservice.warehouse.domain.Article;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record LoadArticlesRequest(

        @JsonProperty("inventory")
        List<Article> articles

) {}
