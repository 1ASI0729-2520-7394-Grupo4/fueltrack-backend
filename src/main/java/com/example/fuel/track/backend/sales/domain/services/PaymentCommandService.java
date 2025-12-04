package com.example.fuel.track.backend.sales.domain.services;

import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import com.example.fuel.track.backend.sales.domain.model.commands.CreatePaymentCommand;

public interface PaymentCommandService {
    Payment handle(CreatePaymentCommand command);
}
