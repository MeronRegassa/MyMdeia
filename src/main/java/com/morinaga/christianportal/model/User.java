package com.morinaga.christianportal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "author")
    private Set<Content> contents;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = true)
    private Member member;

    public User(String username, String password, String email, Set<Content> contents, Set<Comment> comments, Member member) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contents = contents;
        this.comments = comments;
        this.member = member;
    }

// Getters and Setters
}
