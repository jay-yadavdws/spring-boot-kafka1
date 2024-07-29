package dev.jetbrains.spring.kafka.config;

import dev.jetbrains.spring.kafka.model.ProductDetails;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {
    private final KafkaTemplate<String, ProductDetails> kafkaTemplate;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("product-topic")
                .build();
    }
}
