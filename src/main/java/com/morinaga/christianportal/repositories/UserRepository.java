package com.morinaga.christianportal.repositories;


import com.morinaga.christianportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    // This will automatically create a query to fetch all users
   List<User> findAll();

    User findByEmail(String email);

}
