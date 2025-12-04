package com.example.fuel.track.backend.iam.interfaces.rest.transform;

import com.example.fuel.track.backend.iam.domain.model.entities.Role;
import com.example.fuel.track.backend.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
