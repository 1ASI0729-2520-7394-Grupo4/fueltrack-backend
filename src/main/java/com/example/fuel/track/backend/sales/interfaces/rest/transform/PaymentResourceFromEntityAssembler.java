package com.example.fuel.track.backend.sales.interfaces.rest.transform;

import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import com.example.fuel.track.backend.sales.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {

    public static PaymentResource toResourceFromEntity(Payment payment) {
        return new PaymentResource(
                payment.getId(),
                payment.getOrderId(),
                payment.getOrderNumber(),
                payment.getAmount(),
                payment.getStatus(),
                payment.getTransactionId(),
                payment.getProcessedAt(),
                payment.getCreatedAt().toInstant(),
                payment.getCardHolderName(),
                payment.getLastFourDigits(),
                payment.getCardType()
        );
    }
}
