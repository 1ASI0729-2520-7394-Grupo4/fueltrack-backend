package com.example.fuel.track.backend.sales.application.internal.queryservices;

import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;
import com.example.fuel.track.backend.sales.domain.model.queries.GetAllPaymentMethodsQuery;
import com.example.fuel.track.backend.sales.domain.services.PaymentMethodQueryService;
import com.example.fuel.track.backend.sales.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of PaymentMethodQueryService.
 */
@Service
public class PaymentMethodQueryServiceImpl implements PaymentMethodQueryService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodQueryServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<PaymentMethod> handle(GetAllPaymentMethodsQuery query) {
        return paymentMethodRepository.findAll();
    }
}
