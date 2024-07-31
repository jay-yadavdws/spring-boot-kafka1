package dev.jetbrains.spring.kafka.core;

import dev.jetbrains.spring.kafka.enums.ResponseInfoType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseResponse<T> {
    private T data;
    private boolean success;
    private ResponseInfoType status;
}
