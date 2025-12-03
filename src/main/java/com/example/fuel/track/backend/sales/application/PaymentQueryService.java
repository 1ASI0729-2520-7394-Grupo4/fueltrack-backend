package com.example.fuel.track.backend.sales.application;

import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import com.example.fuel.track.backend.sales.infrastructure.persistence.jpa.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentQueryService {

    private final PaymentRepository paymentRepository;

    public PaymentQueryService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
}
