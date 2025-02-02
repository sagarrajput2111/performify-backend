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

    private String firstName;
    private String LastName;
    @JoinColumn(name="address_id",nullable = false)
    @ManyToOne
    private Address address;

    public Principal(User user, String firstName, String lastName, Address address) {
        this.user = user;
        this.firstName = firstName;
        LastName = lastName;
        this.address = address;
    }

    public Principal() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
