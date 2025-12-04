// src/main/java/com/example/fuel/track/backend/sales/interfaces/rest/PaymentController.java
package com.example.fuel.track.backend.sales.interfaces.rest;

import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;
import com.example.fuel.track.backend.sales.domain.model.queries.GetAllPaymentMethodsQuery;
import com.example.fuel.track.backend.sales.domain.model.queries.GetAllPaymentsQuery;
import com.example.fuel.track.backend.sales.domain.services.PaymentMethodQueryService;
import com.example.fuel.track.backend.sales.domain.services.PaymentQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Payments", description = "Payment and payment methods API")

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
        return paymentQueryService.handle(new GetAllPaymentsQuery());
    }

    @GetMapping("/methods")
    @Operation(summary = "Get all payment methods")
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethodQueryService.handle(new GetAllPaymentMethodsQuery());
    }
}
