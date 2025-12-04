package com.example.fuel.track.backend.sales.domain.model.commands;

import java.math.BigDecimal;

public record CreatePaymentCommand(
        Long orderId,
        String orderNumber,
        BigDecimal amount,
        Long paymentMethodId
) { }
