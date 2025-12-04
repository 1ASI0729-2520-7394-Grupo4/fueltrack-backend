// src/main/java/com/example/fuel/track/backend/sales/domain/services/PaymentMethodQueryService.java
package com.example.fuel.track.backend.sales.domain.services;

import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;
import com.example.fuel.track.backend.sales.domain.model.queries.GetAllPaymentMethodsQuery;

import java.util.List;

/**
 * Service that handles payment method queries.
 */
public interface PaymentMethodQueryService {

    /**
     * Handle a query to retrieve all payment methods.
     * @param query the query object (no filters for now).
     * @return list of payment methods.
     */
    List<PaymentMethod> handle(GetAllPaymentMethodsQuery query);
}
