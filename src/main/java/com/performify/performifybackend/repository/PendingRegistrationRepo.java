package com.performify.performifybackend.repository;
import com.performify.performifybackend.models.PendingRegistration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PendingRegistrationRepo extends JpaRepository<PendingRegistration,Long> {
    public Optional<PendingRegistration> findByUsername(String username);
}
