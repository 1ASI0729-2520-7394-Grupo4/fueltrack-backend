package com.example.fuel.track.backend.sales.application;

import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;
import com.example.fuel.track.backend.sales.infrastructure.persistence.jpa.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodQueryService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodQueryService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.findAll();
    }
}
