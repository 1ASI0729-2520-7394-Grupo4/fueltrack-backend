package com.example.fuel.track.backend.sales.domain.model.entities;

import com.example.fuel.track.backend.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "payment_methods")
public class PaymentMethod extends AuditableModel {

    private String cardHolderName;
    private String lastFourDigits;
    private String cardType;
    private LocalDate expiryDate;
    private Boolean isDefault;

    protected PaymentMethod() { }

    public PaymentMethod(String cardHolderName, String lastFourDigits,
                         String cardType, LocalDate expiryDate,
                         Boolean isDefault) {
        this.cardHolderName = cardHolderName;
        this.lastFourDigits = lastFourDigits;
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.isDefault = isDefault;
    }
}
