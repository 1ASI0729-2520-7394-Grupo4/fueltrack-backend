package com.example.fuel.track.backend.sales.interfaces.rest;

import com.example.fuel.track.backend.sales.application.PaymentMethodQueryService;
import com.example.fuel.track.backend.sales.application.PaymentQueryService;
import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Payments")
public class PaymentController {

    private final PaymentQueryService paymentQueryService;
    private final PaymentMethodQueryService paymentMethodQueryService;

    public PaymentController(PaymentQueryService paymentQueryService,
                             PaymentMethodQueryService paymentMethodQueryService) {
        this.paymentQueryService = paymentQueryService;
        this.paymentMethodQueryService = paymentMethodQueryService;
    }

    @GetMapping
    @Operation(summary = "Get all payments")
    public List<Payment> getAllPayments() {
        return paymentQueryService.getAll();
    }

    @GetMapping("/methods")
    @Operation(summary = "Get all payment methods")
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethodQueryService.getAll();
    }
}
