package com.example.fuel.track.backend.iam.interfaces.rest.transform;

import com.example.fuel.track.backend.iam.domain.model.commands.SignUpCommand;

import com.example.fuel.track.backend.iam.domain.model.valueobjects.Roles;
import com.example.fuel.track.backend.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null
                ? resource.roles().stream().map(Roles::valueOf).toList()
                : java.util.List.of(Roles.ROLE_USER);
        return new SignUpCommand(resource.username(), resource.password(), resource.dni(), resource.ruc(), roles);
    }
}
