package com.performify.performifybackend.models;

import jakarta.persistence.*;

@Entity
public class Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // One-to-One relationship with User for authentication

    private String name;
    @JoinColumn(name="address_id",nullable = false)
    @ManyToOne
    private Address address;

    public Principal() {
    }

    public Principal(User user, String name, Address address) {
        this.user = user;
        this.name = name;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
