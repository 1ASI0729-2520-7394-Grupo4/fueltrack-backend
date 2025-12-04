package com.example.fuel.track.backend.sales.domain.model.aggregates;

import com.example.fuel.track.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Table(name = "payments")
public class Payment extends AuditableAbstractAggregateRoot<Payment> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private String orderNumber;

    private BigDecimal amount;

    private Integer status;

    private String transactionId;

    private Instant processedAt;

    // createdAt lo heredas de AuditableAbstractAggregateRoot,

    private String cardHolderName;

    private String lastFourDigits;

    private String cardType;

    protected Payment() { }

    public Payment(Long orderId, String orderNumber, BigDecimal amount,
                   Integer status, String transactionId, Instant processedAt,
                   String cardHolderName,
                   String lastFourDigits, String cardType) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.status = status;
        this.transactionId = transactionId;
        this.processedAt = processedAt;
        this.cardHolderName = cardHolderName;
        this.lastFourDigits = lastFourDigits;
        this.cardType = cardType;
    }

}
