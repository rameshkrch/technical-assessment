package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("Products")
public record Product(

        @Id
        @JsonIgnore
        int id,

        @NotBlank(message = "The name must be defined.")
        String name,

        @Positive
        int price,

        @NotNull
        @JsonProperty("contain_articles")
        List<ProductPart> parts

) {}
