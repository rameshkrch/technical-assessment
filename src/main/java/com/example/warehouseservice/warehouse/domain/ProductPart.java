package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductPart(

        @JsonProperty("art_id")
        String artId,

        @JsonProperty("amount_of")
        Integer quantity

) {}
