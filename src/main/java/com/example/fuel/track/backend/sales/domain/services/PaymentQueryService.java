package com.example.fuel.track.backend.sales.domain.services;

import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import com.example.fuel.track.backend.sales.domain.model.queries.GetAllPaymentsQuery;

import java.util.List;

/**
 * Service that handles payment queries.
 */
public interface PaymentQueryService {

    /**
     * Handle a query to retrieve all payments.
     * @param query the query object (no filters for now).
     * @return list of payments.
     */
    List<Payment> handle(GetAllPaymentsQuery query);
}
