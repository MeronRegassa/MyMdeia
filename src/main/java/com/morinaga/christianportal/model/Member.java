package com.morinaga.christianportal.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private ServiceRole serviceRole;


    @JsonIgnoreProperties({"member"}) // Ignore the circular reference
    @OneToOne(mappedBy = "member")
    private User user;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private Set<Comment> comments;

    public Member(long l,  String john, String doe, String mail, String number, ServiceRole serviceRole) {
    }

    // Getters and Setters
}

