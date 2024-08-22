package com.example.warehouseservice.warehouse.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "PRODUCTPARTS")
public class ProductPartDao {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name="prod_id", nullable=false)
        private ProductDao product;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name="art_id", nullable=false)
        private Article article;

        @Positive
        private int quantity;

        public ProductPartDao() {

        }

        public ProductPartDao(int id, ProductDao product, Article article, int quantity) {
                this.id = id;
                this.product = product;
                this.article = article;
                this.quantity = quantity;
        }

        public ProductPartDao(ProductDao productDao, Article article, int quantity) {
                this(0, productDao, article, quantity);
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public ProductDao getProduct() {
                return product;
        }

        public void setProduct(ProductDao product) {
                this.product = product;
        }

        public Article getArticle() {
                return article;
        }

        public void setArticle(Article article) {
                this.article = article;
        }

        @Positive
        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(@Positive int quantity) {
                this.quantity = quantity;
        }
}
