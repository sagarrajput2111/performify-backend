package com.performify.performifybackend.services;

import com.performify.performifybackend.models.PendingRegistration;
import com.performify.performifybackend.models.User;
import com.performify.performifybackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(@Autowired UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registerUser(PendingRegistration pendingRegistration)
    {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);
        User user=new User(pendingRegistration.getUsername(),passwordEncoder.encode(pendingRegistration.getPassword()) ,pendingRegistration.getRole());
        userRepo.save(user);

    }
}
