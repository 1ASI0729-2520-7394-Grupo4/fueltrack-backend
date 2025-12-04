package com.example.fuel.track.backend.sales.domain.model.events;

import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * Domain event raised when a payment is completed.
 */
public class PaymentCompletedEvent extends ApplicationEvent {

    private final Payment payment;

    public PaymentCompletedEvent(Object source, Payment payment) {
        super(source);
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}
