package com.performify.performifybackend.services;

import com.performify.performifybackend.models.PendingRegistration;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    public void registerTeacher(PendingRegistration pendingRegistration) {
        System.out.println("Teacher Created");
    }
}
