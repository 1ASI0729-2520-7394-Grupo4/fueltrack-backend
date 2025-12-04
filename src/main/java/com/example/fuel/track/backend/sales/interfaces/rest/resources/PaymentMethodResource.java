package com.example.fuel.track.backend.sales.interfaces.rest.resources;

import java.time.Instant;
import java.time.LocalDate;

public record PaymentMethodResource(
        Long id,
        String cardHolderName,
        String lastFourDigits,
        String cardType,
        LocalDate expiryDate,
        Boolean isDefault,
        Instant createdAt
) { }
