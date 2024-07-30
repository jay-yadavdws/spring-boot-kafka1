package dev.jetbrains.spring.kafka.mapper;

import dev.jetbrains.spring.kafka.model.ProductCreatedEvent;
import dev.jetbrains.spring.kafka.model.ProductDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    @Mapping(target = "productId", expression = "java(java.util.UUID.randomUUID().toString())")
    ProductCreatedEvent map(ProductDetails productDetails);
}
