package com.performify.performifybackend.services;

import com.performify.performifybackend.dto.PendingRequests;
import com.performify.performifybackend.dto.RegistrationForm;
import com.performify.performifybackend.models.*;
import com.performify.performifybackend.repository.PendingRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
private PendingRegistrationRepo pendingRegistrationRepo;

   @Autowired
   public  RegistrationService(PendingRegistrationRepo pendingRegistrationRepo)
    {
        this.pendingRegistrationRepo=pendingRegistrationRepo;

    }
    private List<PendingRegistration> pendingRegistrations=new ArrayList<>();

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

    //first we need to send the form for approval to principal/directors

//    public Address registerAddress(RegistrationForm registrationForm)
//    {
//        Address address=new Address(registrationForm.getStreet(), registrationForm.getCity(), registrationForm.getState(), registrationForm.getPostalCode());
//        return address;
//    }
//    public void registerUser(RegistrationForm registrationForm)
//    {
//        User user=new User(registrationForm.getUsername(), registrationForm.getPassword(),registrationForm.getRole());
//
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
