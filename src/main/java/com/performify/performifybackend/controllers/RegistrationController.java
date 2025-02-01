package com.performify.performifybackend.controllers;

import com.performify.performifybackend.dto.PendingRequests;
import com.performify.performifybackend.dto.RegistrationForm;
import com.performify.performifybackend.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//@RequestMapping("/requests")
@RestController
public class RegistrationController {

    private RegistrationService registrationService;
    @Autowired
    RegistrationController(RegistrationService registrationService)
    {
        this.registrationService=registrationService;
    }


    @PreAuthorize("hasAuthority('STUDENT')")
    @PostMapping("/register")
    public String register(@RequestBody RegistrationForm registrationForm)
    {
        registrationService.register(registrationForm);
        return "Request submitted wait till it gets approved";
//        return registrationForm.toString();
    }

    @PreAuthorize("hasAuthority('STUDENT')")
    @GetMapping("/approve/{username}")
    public String approveRegistration(@PathVariable String username)
    {
        System.out.println(username);
        return registrationService.approve(username);

    }

    @PreAuthorize("hasAuthority('STUDENT')")
    @GetMapping("/pending")
    public List<PendingRequests> pendingRequests()
    {
        return registrationService.pendingRequests();

    }
}
