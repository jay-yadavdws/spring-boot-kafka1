package dev.jetbrains.spring.kafka.controller;


import dev.jetbrains.spring.kafka.model.ProductDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/kafka")
public interface KafkaProductController {

    @Operation(tags = "Kafka Producer", summary = "Send msg to Topic.", description = "Send msg to Topic.")
    @ApiResponse(description = "Successful Response.", responseCode = "200")
    @PostMapping("/send-message")
    String kafkaSendMsg(@Valid @RequestBody ProductDetails productDetails);


    @Operation(tags = "Kafka Producer", summary = "Send msg to topic with topicName.", description = "Send msg to topic with topicName.")
    @ApiResponse(description = "Successful Response.", responseCode = "200")
    @PostMapping("/send-message/{topic-name}")
    String sendMessageToTopic(@PathVariable("topic-name") String topicName, @Valid @RequestBody ProductDetails productDetails);
}
