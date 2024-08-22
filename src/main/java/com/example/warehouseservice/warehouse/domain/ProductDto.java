package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record ProductDto(

        @NotBlank(message = "The name must be defined.")
        String name,

        @Positive
        int price,

        @NotNull
        @JsonProperty("contain_articles")
        List<ProductPartDto> parts

) {}
