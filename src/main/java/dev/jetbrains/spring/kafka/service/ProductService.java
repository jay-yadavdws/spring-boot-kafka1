package dev.jetbrains.spring.kafka.service;

import dev.jetbrains.spring.kafka.model.ProductDetails;

public interface ProductService {
    String createProduct(ProductDetails productDetails);
}
