package com.example.fuel.track.backend.control.domain.model.aggregates;

import com.example.fuel.track.backend.control.domain.model.valueobjects.FuelType;
import com.example.fuel.track.backend.control.domain.model.valueobjects.OrderDetails;
import com.example.fuel.track.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "orders")
public class Order extends AuditableAbstractAggregateRoot<Order> {

    private LocalDate created;
    private String user;
    private Double amount;
    private String terminal;
    private String status;

    @Embedded
    private final OrderDetails details;

    public Order() {
        this.created = LocalDate.now();
        this.user = "";
        this.amount = 0.0;
        this.terminal = "";
        this.status = "Requested";
        this.details = new OrderDetails();
    }

    public Order updateInformation(String user, Double amount, String terminal, String status) {
        this.user = user;
        this.amount = amount;
        this.terminal = terminal;
        this.status = status;
        return this;
    }

    public void addDetail(String fuelType, Integer quantity) {
        this.details.addItem(this, new FuelType(fuelType), quantity);
    }
}
