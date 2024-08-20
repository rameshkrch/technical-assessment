package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.relational.core.mapping.Table;

@Table("Articles")
public record Article(

        @NotBlank(message = "The art_id must be defined.")
        @JsonProperty("art_id")
        int id,

        @NotBlank(message = "The article name must be defined.")
        String name,

        @PositiveOrZero
        @JsonProperty("stock")
        int quantity
) {
}
