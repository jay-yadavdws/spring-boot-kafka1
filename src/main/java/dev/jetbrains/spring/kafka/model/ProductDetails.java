package dev.jetbrains.spring.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetails {
    private String productId;
    private String productName;
    private Integer productPrice;
}
