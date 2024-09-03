package com.morinaga.christianportal.repositories;

import com.morinaga.christianportal.model.Category;
import com.morinaga.christianportal.model.Comment;
import com.morinaga.christianportal.model.Content;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


public class ContentRequestDto {
    private Content content;
    private List<Comment> comments;
    private Category category;

    // Constructors, Getters, and Setters

    public ContentRequestDto() {
    }

    public ContentRequestDto(Content content, List<Comment> comments, Category category) {
        this.content = content;
        this.comments = comments;
        this.category = category;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
