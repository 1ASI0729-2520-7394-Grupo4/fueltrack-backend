package com.example.fuel.track.backend.control.infrastructure.persistence.jpa;

import com.example.fuel.track.backend.control.domain.model.aggregates.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
