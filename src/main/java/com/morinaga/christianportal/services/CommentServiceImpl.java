package com.morinaga.christianportal.services;



import com.morinaga.christianportal.config.ResourceNotFoundException;
import com.morinaga.christianportal.model.Comment;
import com.morinaga.christianportal.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }


    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = getCommentById(id);

        comment.setCommentText(commentDetails.getCommentText());
        comment.setCommentDate(commentDetails.getCommentDate());
        comment.setContent(commentDetails.getContent());
        comment.setUser(commentDetails.getUser());
        comment.setMember(commentDetails.getMember());

        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}

