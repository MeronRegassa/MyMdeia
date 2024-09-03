package com.morinaga.christianportal.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore //prevent recursion
    private Set<Content> contents;

    public Category(String name, String description, Set<Content> contents) {
        this.name = name;
        this.description = description;
        this.contents = contents;
    }

//    public  setId( ) {
//    }

    public void setId(long l) {
    }
// Getters and Setters
}