package com.performify.performifybackend.models;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // One-to-One relationship with User for authentication

    private String name;
    private String rollNumber;

    private String standard;
    private String section;
    private String stream;

    @ManyToOne
    @JoinColumn(name="address_id",nullable = false)
    private Address address;


    public Student() {
    }

    public Student(User user, String name, String rollNumber, Address address) {
        this.user = user;
        this.name = name;
        this.rollNumber = rollNumber;
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

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
