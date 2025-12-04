package com.example.fuel.track.backend.sales.interfaces.rest.resources;

import java.math.BigDecimal;
import java.time.Instant;

public record PaymentResource(
        Long id,
        Long orderId,
        String orderNumber,
        BigDecimal amount,
        Integer status,
        String transactionId,
        Instant processedAt,
        Instant createdAt,
        String cardHolderName,
        String lastFourDigits,
        String cardType
) { }
