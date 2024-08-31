package com.morinaga.christianportal.repositories;

import com.morinaga.christianportal.model.Content;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ContentRepository extends JpaRepository<Content, Long> {
    // Custom query method to delete content by authorId
    @Modifying
    @Transactional
    @Query("DELETE FROM Content c WHERE c.author.userId = :authorId")
    void deleteByAuthorId(Long authorId);
}
