package com.example.fuel.track.backend.control.interfaces.rest.resources;

import java.time.LocalDate;
import java.util.List;

public record OrderResource(
        Long id,
        LocalDate created,
        String user,
        Double amount,
        String terminal,
        String status,
        List<OrderDetailResource> details
) {}
