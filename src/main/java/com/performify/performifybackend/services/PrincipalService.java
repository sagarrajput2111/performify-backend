package com.performify.performifybackend.services;

import com.performify.performifybackend.models.PendingRegistration;
import org.springframework.stereotype.Service;

@Service
public class PrincipalService {
    public void registerPrincipal(PendingRegistration pendingRegistration) {
        System.out.println("Principal Created");
    }
}
