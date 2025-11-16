package com.example.fuel.track.backend.control.application;

import com.example.fuel.track.backend.control.domain.model.aggregates.Order;
import com.example.fuel.track.backend.control.infrastructure.persistence.jpa.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public OrderQueryService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
