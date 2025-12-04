package com.example.fuel.track.backend.sales.application.internal.queryservices;

import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import com.example.fuel.track.backend.sales.domain.model.queries.GetAllPaymentsQuery;
import com.example.fuel.track.backend.sales.domain.services.PaymentQueryService;
import com.example.fuel.track.backend.sales.infrastructure.persistence.jpa.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of PaymentQueryService.
 */
@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {

    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> handle(GetAllPaymentsQuery query) {
        return paymentRepository.findAll();
    }
}
