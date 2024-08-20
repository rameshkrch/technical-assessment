package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Product(

        String name,

        Integer price,

        @JsonProperty("contain_articles")
        List<ProductPart> parts

) {}
