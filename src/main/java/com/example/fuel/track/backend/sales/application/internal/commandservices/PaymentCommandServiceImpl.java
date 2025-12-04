package com.example.fuel.track.backend.sales.application.internal.commandservices;

import com.example.fuel.track.backend.sales.domain.exceptions.PaymentMethodNotFoundException;
import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import com.example.fuel.track.backend.sales.domain.model.commands.CreatePaymentCommand;
import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;
import com.example.fuel.track.backend.sales.domain.services.PaymentCommandService;
import com.example.fuel.track.backend.sales.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;
import com.example.fuel.track.backend.sales.infrastructure.persistence.jpa.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {

    private final PaymentRepository paymentRepository;
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository,
                                     PaymentMethodRepository paymentMethodRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public Payment handle(CreatePaymentCommand command) {

        PaymentMethod method = paymentMethodRepository.findById(command.paymentMethodId())
                .orElseThrow(() -> new PaymentMethodNotFoundException(command.paymentMethodId()));

        Instant now = Instant.now();
        String transactionId = "TXN_" + now.toString().replace(":", "").replace("-", "") +
                "-" + UUID.randomUUID().toString().substring(0, 4);

        int initialStatus = 0; // o el código que uses para PENDING

        Payment payment = new Payment(
                command.orderId(),
                command.orderNumber(),
                command.amount(),
                initialStatus,
                transactionId,
                null,
                method.getCardHolderName(),
                method.getLastFourDigits(),
                method.getCardType()
        );

        return paymentRepository.save(payment);
    }
}
