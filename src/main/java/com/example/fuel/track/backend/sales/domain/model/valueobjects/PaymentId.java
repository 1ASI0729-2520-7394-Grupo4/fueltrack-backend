package com.example.fuel.track.backend.sales.domain.model.valueobjects;

import java.util.UUID;

public record PaymentId(UUID value) {
    public static PaymentId newId(){
        return new PaymentId(UUID.randomUUID());
    }
}
