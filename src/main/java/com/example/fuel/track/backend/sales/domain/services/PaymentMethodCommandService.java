package com.example.fuel.track.backend.sales.domain.services;

import com.example.fuel.track.backend.sales.domain.model.commands.CreatePaymentMethodCommand;
import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;

public interface PaymentMethodCommandService {
    PaymentMethod handle(CreatePaymentMethodCommand command);
}
