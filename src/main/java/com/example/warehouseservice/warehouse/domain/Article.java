package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;


@Entity
@Table(name = "ARTICLES")
public class Article {

        @Id
        @Positive(message = "The art_id must be defined.")
        @JsonProperty("art_id")
        private int id;

        @NotBlank(message = "The article name must be defined.")
        private String name;

        @PositiveOrZero
        @JsonProperty("stock")
        private int quantity;

        public Article() {

        }

        public Article(int id, String name, int quantity) {
                this.id = id;
                this.name = name;
                this.quantity = quantity;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public @NotBlank(message = "The article name must be defined.") String getName() {
                return name;
        }

        public void setName(@NotBlank(message = "The article name must be defined.") String name) {
                this.name = name;
        }

        @PositiveOrZero
        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(@PositiveOrZero int quantity) {
                this.quantity = quantity;
        }
}
