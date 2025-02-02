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

    private String firstName;
    private String lastName;
    private String department;
    private String subject;
    @JoinColumn(name="address_id",nullable = false)
    @ManyToOne
    private Address address;

    public Teacher() {
    }

    public Teacher(User user, String firstName, String lastName, String department, String subject, Address address) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.subject = subject;
        this.address = address;
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
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
