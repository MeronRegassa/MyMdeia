package com.morinaga.christianportal.repositories;


import com.morinaga.christianportal.model.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentDTO {
    private Long contentId;
    private String title;
    private String description;
    private String contentType;
    private Date uploadDate;

    public ContentDTO(Content savedContent) {
    }

    // constructor, getters, and setters
}
