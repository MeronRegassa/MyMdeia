package com.morinaga.christianportal.dto;

import com.morinaga.christianportal.model.ServiceRole;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class MemberDto {
    private Long memberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private ServiceRole  serviceRole;

    // Constructors, getters, and setters
    public MemberDto(Long memberId, String firstName, String lastName, String email, String phoneNumber,ServiceRole serviceRole) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.serviceRole = serviceRole;
    }
    public MemberDto(){

    }
    // Getters and setters
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public ServiceRole getServiceRole() { return serviceRole; }
    public void setServiceRole(ServiceRole serviceRole) { this.serviceRole = serviceRole; }

}
