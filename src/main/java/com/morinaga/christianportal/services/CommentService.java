package com.morinaga.christianportal.services;


import com.morinaga.christianportal.model.Comment;
import com.morinaga.christianportal.model.Content;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);
    Comment getCommentById(Long id);
    List<Comment> getAllComments();
    Comment updateComment(Long id, Comment commentDetails);
    void deleteComment(Long id);
}
