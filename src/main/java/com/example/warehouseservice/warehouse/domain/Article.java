package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Article(

        @JsonProperty("art_id")
        String id,

        String name,

        @JsonProperty("stock")
        Integer quantity
) {
}
