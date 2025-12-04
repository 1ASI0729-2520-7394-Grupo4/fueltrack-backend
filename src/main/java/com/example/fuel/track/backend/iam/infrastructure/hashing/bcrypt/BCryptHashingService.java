package com.example.fuel.track.backend.iam.infrastructure.hashing.bcrypt;

import com.example.fuel.track.backend.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This interface is a marker interface for the BCrypt hashing service.
 * It extends the {@link HashingService} and {@link PasswordEncoder} interfaces.
 * This interface is used to inject the BCrypt hashing service
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
