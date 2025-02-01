package com.performify.performifybackend.services;

import com.performify.performifybackend.dto.PendingRequests;
import com.performify.performifybackend.dto.RegistrationForm;
import com.performify.performifybackend.models.*;
import com.performify.performifybackend.repository.PendingRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
private PendingRegistrationRepo pendingRegistrationRepo;
private UserService userService;
private List<PendingRegistration> pendingRegistrations;
private StudentService studentService;
private TeacherService teacherService;
private PrincipalService principalService;
    @Autowired
    public RegistrationService(PendingRegistrationRepo pendingRegistrationRepo, UserService userService, StudentService studentService, TeacherService teacherService, PrincipalService principalService) {
        this.pendingRegistrationRepo = pendingRegistrationRepo;
        this.userService = userService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.principalService = principalService;
    }



//   public  RegistrationService(PendingRegistrationRepo pendingRegistrationRepo,  UserService userService)
//    {
//        this.pendingRegistrationRepo=pendingRegistrationRepo;
//        this.userService=userService;
//
//    }


    public void register(RegistrationForm registrationForm)
    {
        PendingRegistration pendingRegistration=new PendingRegistration();
        pendingRegistration.setFirstName(registrationForm.getFirstName());
        pendingRegistration.setLastName(registrationForm.getLastName());
        pendingRegistration.setUsername(registrationForm.getUsername());
        pendingRegistration.setPassword(registrationForm.getPassword());
        pendingRegistration.setEmail(registrationForm.getEmail());
        pendingRegistration.setStreet(registrationForm.getStreet());
        pendingRegistration.setCity(registrationForm.getCity());
        pendingRegistration.setState(registrationForm.getState());
        pendingRegistration.setPostalCode(registrationForm.getPostalCode());
        pendingRegistration.setDateOfBirth(registrationForm.getDateOfBirth());
        pendingRegistration.setDepartment(registrationForm.getDepartment());
        pendingRegistration.setRole(registrationForm.getRole());
        pendingRegistration.setStandard(registrationForm.getStandard());
        pendingRegistration.setSubject(registrationForm.getSubject());
        pendingRegistration.setStream(registrationForm.getStream());
        pendingRegistrationRepo.save(pendingRegistration);

    }

    public List<PendingRequests> pendingRequests()
    {
        pendingRegistrations=new ArrayList<>();
        pendingRegistrations= pendingRegistrationRepo.findAll();
        ArrayList<PendingRequests> pendingRequestList=new ArrayList<>();
        pendingRegistrations.stream().filter(registration->
        {
            return !(registration.isApproved());
        }).forEach((registration)->
        {
            PendingRequests pendingRequest=new PendingRequests();
            pendingRequest.setUsername(registration.getUsername());
            pendingRequest.setRole(registration.getRole());
            pendingRequest.setCity(registration.getCity());
            pendingRequest.setDepartment(registration.getDepartment());
            pendingRequest.setStandard(registration.getStandard());
            pendingRequest.setFirstName(registration.getFirstName());
            pendingRequest.setStream(registration.getStream());
            pendingRequest.setState(registration.getState());
            pendingRequest.setStreet(registration.getStreet());
            pendingRequest.setSubject(registration.getSubject());
            pendingRequest.setPostalCode(registration.getPostalCode());
            pendingRequest.setLastName(registration.getLastName());
            pendingRequest.setDateOfBirth(registration.getDateOfBirth());
            pendingRequestList.add(pendingRequest);

        });

        return pendingRequestList;
    }

    public String approve(String username)
    {
        PendingRegistration pendingRegistration=pendingRegistrationRepo.findByUsername(username).get();
        if(pendingRegistration!=null) {
            pendingRegistration.setApproved(true);
            pendingRegistrationRepo.save(pendingRegistration);
//            userService.registerUser(pendingRegistration);
            triggerCreationWorkFlow(pendingRegistration);




        }
        /*
        pendingRegistrations.forEach(p->{
            System.out.println(p.getUsername().trim().equals(username.trim()));
        });

        Optional<PendingRegistration> optionalPending = pendingRegistrations.stream()
                .filter(p -> p.getUsername().equals(username) && !p.isApproved())
                .findFirst();


        if (optionalPending.isPresent()) {
            System.out.println("not present");
//            PendingRegistration pending = optionalPending.get();
            pending.setApproved(true); // Update the approved status
            return "Registration for " + username + " approved successfully.";
        } else {
            System.out.println("not present");
            return "No pending registration found for username: " + username;
        }

        */
        return "Approved";

    }

    public void triggerCreationWorkFlow(PendingRegistration pendingRegistration)
    {
        userService.registerUser(pendingRegistration);
        switch (pendingRegistration.getRole()){
            case STUDENT -> studentService.registerStudent(pendingRegistration);
            case TEACHER -> teacherService.registerTeacher(pendingRegistration);
            case PRINCIPAL -> principalService.registerPrincipal(pendingRegistration);
        }


    }

    //first we need to send the form for approval to principal/directors

//    public Address registerAddress(RegistrationForm registrationForm)
//    {
//        Address address=new Address(registrationForm.getStreet(), registrationForm.getCity(), registrationForm.getState(), registrationForm.getPostalCode());
//        return address;
//    }

//
//    public void registerStudent(RegistrationForm registrationForm)
//    {
//        Student student=new Student(user,registrationForm.getFirstName(),registrationForm.getLastName(),address)
//
//    }
//    public void registerTeacher()
//    {
//
//    }

}
