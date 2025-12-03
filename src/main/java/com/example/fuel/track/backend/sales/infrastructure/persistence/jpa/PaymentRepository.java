package com.example.fuel.track.backend.sales.infrastructure.persistence.jpa;

import com.example.fuel.track.backend.sales.domain.model.aggregates.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
