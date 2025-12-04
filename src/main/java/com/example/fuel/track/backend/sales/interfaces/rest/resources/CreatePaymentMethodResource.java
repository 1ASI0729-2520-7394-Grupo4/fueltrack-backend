package com.example.fuel.track.backend.sales.interfaces.rest.resources;

import java.time.LocalDate;

public record CreatePaymentMethodResource(
        String cardHolderName,
        String lastFourDigits,
        String cardType,
        LocalDate expiryDate,
        Boolean isDefault
) { }
