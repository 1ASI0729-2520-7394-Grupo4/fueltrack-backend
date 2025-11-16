package com.example.fuel.track.backend.control.interfaces.rest.resources;

import java.util.List;

public record OrdersResource(
        List<OrderResource> orders
) {}
