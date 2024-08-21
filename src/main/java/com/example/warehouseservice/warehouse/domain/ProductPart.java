package com.example.warehouseservice.warehouse.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

@Entity
@Table(name = "PRODUCTPARTS")
public class ProductPart {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        private int id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name="prod_id", nullable=false)
        @JsonIgnore
        private Product product;

        @Positive(message = "The art_id must be defined.")
        @JsonProperty("art_id")
        private int artId;

        @Positive
        @JsonProperty("amount_of")
        private int quantity;

        public ProductPart() {

        }

        public ProductPart(int id, Product product, int artId, int quantity) {
                this.id = id;
                this.product = product;
                this.artId = artId;
                this.quantity = quantity;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public Product getProduct() {
                return product;
        }

        public void setProduct(Product product) {
                this.product = product;
        }

        public int getArtId() {
                return artId;
        }

        public void setArtId(int artId) {
                this.artId = artId;
        }

        @Positive
        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(@Positive int quantity) {
                this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ProductPart that = (ProductPart) o;
                return id == that.id && artId == that.artId && quantity == that.quantity && Objects.equals(product, that.product);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, product, artId, quantity);
        }
}
