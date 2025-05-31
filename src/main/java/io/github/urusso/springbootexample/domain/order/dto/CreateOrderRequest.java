package io.github.urusso.springbootexample.domain.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateOrderRequest(
        Long userId,
        String productName,
        BigDecimal price,
        LocalDateTime timestamp
) {}
