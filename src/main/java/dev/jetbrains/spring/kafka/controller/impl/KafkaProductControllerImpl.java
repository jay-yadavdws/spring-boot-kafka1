package dev.jetbrains.spring.kafka.controller.impl;

import dev.jetbrains.spring.kafka.controller.KafkaProductController;
import dev.jetbrains.spring.kafka.model.ProductDetails;
import dev.jetbrains.spring.kafka.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class KafkaProductControllerImpl implements KafkaProductController {
    //TODO : auto-format on save plugin
    private final ProductService productService;

    @Override
    public String kafkaSendMsg(ProductDetails productDetails) {
        String productId = productService.createProduct(productDetails);
        log.info("Product with id : {} send to Kafka producer.", productId);
        return productId;
    }

    @Override
    public String sendMessageToTopic(String topicName, ProductDetails productDetails) {
        String productId = productService.createProduct(productDetails);
        log.info("Product with id : {} send to Kafka topic : {} .", productId, topicName);
        return productId;
    }
}
