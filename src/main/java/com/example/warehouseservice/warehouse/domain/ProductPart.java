package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("ProductParts")
public record ProductPart(

        @Id
        @JsonIgnore
        int id,

        @JsonIgnore
        int prodId,

        @NotBlank(message = "The art_id must be defined.")
        @JsonProperty("art_id")
        int artId,

        @Positive
        @JsonProperty("amount_of")
        int quantity

) {
        public ProductPart(int prodId, int artId, int quantity) {
                this(0, prodId, artId, quantity);
        }
}
