package com.example.fuel.track.backend.sales.interfaces.rest.transform;

import com.example.fuel.track.backend.sales.domain.model.entities.PaymentMethod;
import com.example.fuel.track.backend.sales.interfaces.rest.resources.PaymentMethodResource;

public class PaymentMethodResourceFromEntityAssembler {

    public static PaymentMethodResource toResourceFromEntity(PaymentMethod method) {
        return new PaymentMethodResource(
                method.getId(),
                method.getCardHolderName(),
                method.getLastFourDigits(),
                method.getCardType(),
                method.getExpiryDate(),
                method.getIsDefault(),
                method.getCreatedAt().toInstant()
        );
    }
}
