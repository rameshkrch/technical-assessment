package com.example.warehouseservice.warehouse.web;

import com.example.warehouseservice.warehouse.domain.Product;

import java.util.List;

public record LoadProductsRequest(

        List<Product> products

) {}
