package com.example.fuel.track.backend.sales.interfaces.rest.transform;

import com.example.fuel.track.backend.sales.domain.model.commands.CreatePaymentMethodCommand;
import com.example.fuel.track.backend.sales.interfaces.rest.resources.CreatePaymentMethodResource;

public class CreatePaymentMethodCommandFromResourceAssembler {

    public static CreatePaymentMethodCommand toCommandFromResource(
            CreatePaymentMethodResource resource) {

        return new CreatePaymentMethodCommand(
                resource.cardHolderName(),
                resource.lastFourDigits(),
                resource.cardType(),
                resource.expiryDate(),
                resource.isDefault()
        );
    }
}
