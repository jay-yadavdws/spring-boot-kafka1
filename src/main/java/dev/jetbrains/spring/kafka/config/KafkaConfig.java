package dev.jetbrains.spring.kafka.config;

import dev.jetbrains.spring.kafka.model.ProductDetails;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {
    private final KafkaTemplate<String, ProductDetails> kafkaTemplate;

    @Value("${kafka-product-topic-name}")
    private String productEventTopic;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder
                .name(productEventTopic)
                .partitions(3)
                .replicas(1) // should be less than or equal to no of brokers
                .configs(Map.of("min.insync.replicas", "1"))
                .build();
    }
}
