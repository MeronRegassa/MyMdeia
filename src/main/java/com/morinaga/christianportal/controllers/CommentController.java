package com.morinaga.christianportal.controllers;


import com.morinaga.christianportal.model.Comment;
import com.morinaga.christianportal.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.saveComment(comment), HttpStatus.CREATED);
    }
}
