package com.morinaga.christianportal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    private String title;
    private String description;
    private String contentType;
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "author_id",  referencedColumnName = "userId")
    @JsonBackReference  //Use @JsonIgnore or @JsonBackReference and @JsonManagedReference annotations to manage serialization of bidirectional relationships.
    private User author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "content")
    private Set<Comment> comments;

    public Content(String title, String description, String contentType, Date uploadDate, User author, Category category, Set<Comment> comments) {
        this.title = title;
        this.description = description;
        this.contentType = contentType;
        this.uploadDate = uploadDate;
        this.author = author;
        this.category = category;
        this.comments = comments;
    }
// Getters and Setters
}