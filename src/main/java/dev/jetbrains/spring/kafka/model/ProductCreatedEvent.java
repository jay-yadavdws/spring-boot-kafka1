package dev.jetbrains.spring.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
}
