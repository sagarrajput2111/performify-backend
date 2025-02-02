package com.performify.performifybackend.services;

import com.performify.performifybackend.models.Address;
import com.performify.performifybackend.models.PendingRegistration;
import com.performify.performifybackend.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }


    public Address registerAddress(PendingRegistration pendingRegistration) {
        Address address=new Address(pendingRegistration.getStreet(),pendingRegistration.getCity(), pendingRegistration.getState(),pendingRegistration.getPostalCode());
        addressRepo.save(address);
        return address;
    }
}
