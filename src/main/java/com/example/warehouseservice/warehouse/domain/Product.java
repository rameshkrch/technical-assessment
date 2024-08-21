package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        private int id;

        @NotBlank(message = "The name must be defined.")
        private String name;

        @Positive
        private int price;

        @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
        @NotNull
        @JsonProperty("contain_articles")
        private List<ProductPart> parts;

        public Product() {

        }

        public Product(int id, String name, int price, List<ProductPart> parts) {
                this.id = id;
                this.name = name;
                this.price = price;
                this.parts = parts;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public @NotBlank(message = "The name must be defined.") String getName() {
                return name;
        }

        public void setName(@NotBlank(message = "The name must be defined.") String name) {
                this.name = name;
        }

        @Positive
        public int getPrice() {
                return price;
        }

        public void setPrice(@Positive int price) {
                this.price = price;
        }

        public @NotNull List<ProductPart> getParts() {
                return parts;
        }

        public void setParts(@NotNull List<ProductPart> parts) {
                this.parts = parts;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Product product = (Product) o;
                return id == product.id && price == product.price && Objects.equals(name, product.name) && Objects.equals(parts, product.parts);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, price, parts);
        }
}
