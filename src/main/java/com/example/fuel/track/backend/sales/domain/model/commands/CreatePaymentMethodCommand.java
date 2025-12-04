package com.example.fuel.track.backend.sales.domain.model.commands;

import java.time.LocalDate;

public record CreatePaymentMethodCommand(
        String cardHolderName,
        String lastFourDigits,
        String cardType,
        LocalDate expiryDate,
        Boolean isDefault
) { }
