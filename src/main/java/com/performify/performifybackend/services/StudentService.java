package com.performify.performifybackend.services;

import com.performify.performifybackend.models.PendingRegistration;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void registerStudent(PendingRegistration pendingRegistration) {
        System.out.println("Student Created");
    }
}
