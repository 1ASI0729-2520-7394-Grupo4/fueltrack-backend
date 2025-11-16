package com.example.fuel.track.backend.control.domain.model.valueobjects;

import com.example.fuel.track.backend.control.domain.model.aggregates.Order;
import com.example.fuel.track.backend.control.domain.model.entities.OrderDetail;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Embeddable
public class OrderDetails {

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> details;

    public OrderDetails() {
        this.details = new ArrayList<>();
    }

    private OrderDetail getFirstDetailWhere(Predicate<OrderDetail> predicate) {
        return details.stream().filter(predicate).findFirst().orElse(null);
    }

    public OrderDetail getDetailById(Long id) {
        return getFirstDetailWhere(detail -> detail.getId().equals(id));
    }

    public boolean isEmpty() {
        return details.isEmpty();
    }

    public void addItem(Order order, FuelType fuelType, Integer quantity) {
        OrderDetail detail = new OrderDetail(order, fuelType, quantity);
        details.add(detail);
    }

    public List<OrderDetail> getDetails() {
        return details;
    }
}
