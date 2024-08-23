package com.morinaga.christianportal.repositories;

import com.morinaga.christianportal.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
