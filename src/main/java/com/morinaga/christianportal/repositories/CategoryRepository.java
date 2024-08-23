package com.morinaga.christianportal.repositories;

import com.morinaga.christianportal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
