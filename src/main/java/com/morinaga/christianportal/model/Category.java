package com.morinaga.christianportal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Content> contents;

    public Category(String name, String description, Set<Content> contents) {
        this.name = name;
        this.description = description;
        this.contents = contents;
    }
// Getters and Setters
}