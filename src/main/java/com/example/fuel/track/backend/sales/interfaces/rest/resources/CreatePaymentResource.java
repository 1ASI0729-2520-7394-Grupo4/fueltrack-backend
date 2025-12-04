package com.example.fuel.track.backend.sales.interfaces.rest.resources;

import java.math.BigDecimal;

public record CreatePaymentResource(
        Long orderId,
        String orderNumber,
        BigDecimal amount,
        Long paymentMethodId
) { }
