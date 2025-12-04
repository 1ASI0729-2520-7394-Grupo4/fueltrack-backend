package com.example.fuel.track.backend.sales.interfaces.rest.transform;

import com.example.fuel.track.backend.sales.domain.model.commands.CreatePaymentCommand;
import com.example.fuel.track.backend.sales.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {

    public static CreatePaymentCommand toCommandFromResource(
            CreatePaymentResource resource) {

        return new CreatePaymentCommand(
                resource.orderId(),
                resource.orderNumber(),
                resource.amount(),
                resource.paymentMethodId()
        );
    }
}
