package com.performify.performifybackend.services;

import com.performify.performifybackend.models.Address;
import com.performify.performifybackend.models.PendingRegistration;
import com.performify.performifybackend.models.Principal;
import com.performify.performifybackend.models.User;
import com.performify.performifybackend.repository.PrincipalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrincipalService {

    private PrincipalRepo principalRepo;

    @Autowired
    public PrincipalService(PrincipalRepo principalRepo) {
        this.principalRepo = principalRepo;
    }

    public void registerPrincipal(PendingRegistration pendingRegistration, Address address, User user) {
        Principal principal=new Principal(user,pendingRegistration.getFirstName(),pendingRegistration.getLastName(),address);
        principalRepo.save(principal);
        System.out.println("Principal Created");
    }
}
