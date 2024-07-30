package dev.jetbrains.spring.kafka.controller;

import dev.jetbrains.spring.kafka.model.ProductDetails;
import dev.jetbrains.spring.kafka.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaProductController {

    private final ProductService productService;

    @PostMapping("/send-message")
    public String kafkaSendMsg(@RequestBody ProductDetails productDetails) {
        String productId = productService.createProduct(productDetails);
        return productId;
    }
}
