package com.example.fuel.track.backend.sales.infrastructure.persistence.jpa.repositories;

import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
