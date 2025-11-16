package com.example.fuel.track.backend.control.domain.model.entities;

import com.example.fuel.track.backend.control.domain.model.aggregates.Order;
import com.example.fuel.track.backend.control.domain.model.valueobjects.FuelType;
import com.example.fuel.track.backend.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class OrderDetail extends AuditableModel {

    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull
    private Order order;

    @NotNull
    @Embedded
    private FuelType fuelType;

    @NotNull
    private Integer quantity;

    public OrderDetail(Order order, FuelType fuelType, Integer quantity) {
        this.order = order;
        this.fuelType = fuelType;
        this.quantity = quantity;
    }

    public OrderDetail() {
        this.fuelType = new FuelType("");
        this.quantity = 0;
    }

    public void updateQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void updateFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
}
