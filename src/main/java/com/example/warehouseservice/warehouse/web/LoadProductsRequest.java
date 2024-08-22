package com.example.warehouseservice.warehouse.web;

import com.example.warehouseservice.warehouse.domain.ProductDto;

import java.util.List;

public record LoadProductsRequest(

        List<ProductDto> products

) {}
