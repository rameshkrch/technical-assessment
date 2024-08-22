package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Objects;


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

        public Article(int id) {
                this(id, "", 0);
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

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Article article = (Article) o;
                return id == article.id && quantity == article.quantity && Objects.equals(name, article.name);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, quantity);
        }
}
