package com.morinaga.christianportal.repositories;


import com.morinaga.christianportal.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
