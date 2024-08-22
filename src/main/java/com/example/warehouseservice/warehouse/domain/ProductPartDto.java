package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;

public record ProductPartDto(

        @Positive(message = "The art_id must be defined.")
        @JsonProperty("art_id")
        int artId,

        @Positive
        @JsonProperty("amount_of")
        int quantity

) {}