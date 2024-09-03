package com.morinaga.christianportal.services;

import com.morinaga.christianportal.model.Category;
import com.morinaga.christianportal.model.Comment;
import com.morinaga.christianportal.model.Content;

import java.util.List;

public interface ContentService {
    Content saveContent(Content content);
    Content getContentById(Long id);
    List<Content> getAllContents();
    Content updateContent(Long id, Content contentDetails);
    void deleteContent(Long id);
    boolean checkPassword(String rawPassword, String encodedPassword);


    Comment addCommentToContent(Long id, Comment comment);

//    Content saveAllContentDetails(Content content, List<Comment> comments, Category category);
}
