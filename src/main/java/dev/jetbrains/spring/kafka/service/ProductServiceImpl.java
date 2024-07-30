package dev.jetbrains.spring.kafka.service;

import dev.jetbrains.spring.kafka.mapper.ProductMapper;
import dev.jetbrains.spring.kafka.model.ProductCreatedEvent;
import dev.jetbrains.spring.kafka.model.ProductDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    @Value("${kafka-product-topic-name}")
    private String productEventTopic;

    @Override
    public String createProduct(ProductDetails productDetails) {
        ProductCreatedEvent event = productMapper.map(productDetails);
        var sendResultCompletableFuture = kafkaTemplate.send(productEventTopic, event);
        SendResult<String, ProductCreatedEvent> sendResult = sendResultCompletableFuture.join();
        log.info("Send Result : {}", sendResult);
        return event.getProductId();
    }
}
