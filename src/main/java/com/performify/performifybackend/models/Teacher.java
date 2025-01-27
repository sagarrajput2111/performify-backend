package com.performify.performifybackend.models;


import jakarta.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // One-to-One relationship with User for authentication

    private String name;
    private String department;
    private String subject;
    @JoinColumn(name="address_id",nullable = false)
    @ManyToOne
    private Address address;

    public Teacher() {
    }

    public Teacher(User user, String name, String department, Address address) {
        this.user = user;
        this.name = name;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
