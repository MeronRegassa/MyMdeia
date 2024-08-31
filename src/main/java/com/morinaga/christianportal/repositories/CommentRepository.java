package com.morinaga.christianportal.repositories;


import com.morinaga.christianportal.model.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Content c WHERE c.author.userId = :authorId")
//    void deleteByAuthorId(Long authorId);
}
