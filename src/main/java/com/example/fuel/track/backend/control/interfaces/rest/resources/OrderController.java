package com.example.fuel.track.backend.control.interfaces.rest.resources;

import com.example.fuel.track.backend.control.application.OrderQueryService;
import com.example.fuel.track.backend.control.domain.model.aggregates.Order;
import com.example.fuel.track.backend.control.domain.model.entities.OrderDetail;
import com.example.fuel.track.backend.control.interfaces.rest.resources.OrderDetailResource;
import com.example.fuel.track.backend.control.interfaces.rest.resources.OrderResource;
import com.example.fuel.track.backend.control.interfaces.rest.resources.OrdersResource;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderQueryService orderQueryService;

    public OrderController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    @Operation(summary = "Get all fuel orders")
    @GetMapping
    public OrdersResource getOrders() {
        List<Order> orders = orderQueryService.getAll();

        List<OrderResource> orderResources = orders.stream()
                .map(this::toResource)
                .toList();

        return new OrdersResource(orderResources);
    }

    private OrderResource toResource(Order order) {
        List<OrderDetailResource> details = order.getDetails().getDetails().stream()
                .map(this::toDetailResource)
                .toList();

        return new OrderResource(
                order.getId(),
                order.getCreated(),
                order.getUser(),
                order.getAmount(),
                order.getTerminal(),
                order.getStatus(),
                details
        );
    }

    private OrderDetailResource toDetailResource(OrderDetail detail) {
        return new OrderDetailResource(
                detail.getId(),
                detail.getFuelType().getValue(),
                detail.getQuantity()
        );
    }
}
