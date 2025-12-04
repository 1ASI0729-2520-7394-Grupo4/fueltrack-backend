package com.example.fuel.track.backend.sales.domain.exceptions;

/**
 * Exception thrown when a payment method is not found.
 */
public class PaymentMethodNotFoundException extends RuntimeException {
    public PaymentMethodNotFoundException(Long paymentMethodId) {
        super(String.format("Payment method with id %d not found.", paymentMethodId));
    }
}
