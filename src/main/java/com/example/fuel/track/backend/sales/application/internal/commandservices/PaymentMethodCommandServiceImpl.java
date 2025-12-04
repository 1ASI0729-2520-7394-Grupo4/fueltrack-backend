package com.example.fuel.track.backend.sales.application.internal.commandservices;

import com.example.fuel.track.backend.sales.domain.model.commands.CreatePaymentMethodCommand;
import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;
import com.example.fuel.track.backend.sales.domain.services.PaymentMethodCommandService;
import com.example.fuel.track.backend.sales.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodCommandServiceImpl implements PaymentMethodCommandService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodCommandServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethod handle(CreatePaymentMethodCommand command) {
        PaymentMethod method = new PaymentMethod(
                command.cardHolderName(),
                command.lastFourDigits(),
                command.cardType(),
                command.expiryDate(),
                Boolean.TRUE.equals(command.isDefault())
        );

        return paymentMethodRepository.save(method);
    }
}
