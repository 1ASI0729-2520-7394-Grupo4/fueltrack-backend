package com.example.fuel.track.backend.control.interfaces.rest.resources;

public record OrderDetailResource(
        Long id,
        String fuelType,
        Integer quantity
) {}
