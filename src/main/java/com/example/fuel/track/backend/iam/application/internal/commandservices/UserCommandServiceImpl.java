package com.example.fuel.track.backend.iam.application.internal.commandservices;

import com.example.fuel.track.backend.iam.application.internal.outboundservices.hashing.HashingService;
import com.example.fuel.track.backend.iam.application.internal.outboundservices.tokens.TokenService;
import com.example.fuel.track.backend.iam.domain.model.aggregates.User;
import com.example.fuel.track.backend.iam.domain.model.commands.SignInCommand;
import com.example.fuel.track.backend.iam.domain.model.commands.SignUpCommand;
import com.example.fuel.track.backend.iam.domain.services.UserCommandService;
import com.example.fuel.track.backend.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.example.fuel.track.backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService,
                                  TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty())
            throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.get().getUsername());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        // Validar username único
        if (userRepository.existsByUsername(command.username()))
            throw new RuntimeException("Username already exists");

        // Validar DNI único
        if (userRepository.existsByDni(command.dni()))
            throw new RuntimeException("DNI already exists");

        // Validar RUC único (solo si se proporciona)
        if (command.ruc() != null && !command.ruc().isEmpty()) {
            if (userRepository.existsByRuc(command.ruc()))
                throw new RuntimeException("RUC already exists");
        }

        // Obtener roles
        var roles = command.roles().stream()
                .map(role -> roleRepository.findByName(role)
                        .orElseThrow(() -> new RuntimeException("Role name not found" + role)))
                .toList();

        // Crear usuario con DNI y RUC
        var user = new User(
                command.username(),
                hashingService.encode(command.password()),
                command.dni(),
                command.ruc(),
                roles
        );

        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }
}