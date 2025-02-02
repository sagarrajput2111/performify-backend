package com.performify.performifybackend.repository;
import com.performify.performifybackend.models.PendingRegistration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PendingRegistrationRepo extends JpaRepository<PendingRegistration,Long> {
    public Optional<PendingRegistration> findByUsername(String username);
}
