package com.morinaga.christianportal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String commentText;
    private Date commentDate;

    @ManyToOne
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public Comment(String commentText, Date commentDate, Content content, User user, Member member) {
        this.commentText = commentText;
        this.commentDate = commentDate;
        this.content = content;
        this.user = user;
        this.member = member;
    }
// Getters and Setters
}
