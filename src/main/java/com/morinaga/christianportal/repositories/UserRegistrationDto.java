package com.morinaga.christianportal.repositories;

import com.morinaga.christianportal.model.ServiceRole;

public class UserRegistrationDto {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private ServiceRole serviceRole;

    // Getters and Setters
    public UserRegistrationDto(){

    }

    public UserRegistrationDto(String username, String password, String email, String firstName, String lastName, String phoneNumber, ServiceRole serviceRole) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.serviceRole = serviceRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ServiceRole getServiceRole() {
        return serviceRole;
    }

    public void setServiceRole(ServiceRole serviceRole) {
        this.serviceRole = serviceRole;
    }
}