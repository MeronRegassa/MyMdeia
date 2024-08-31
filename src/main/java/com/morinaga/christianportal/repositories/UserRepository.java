package com.morinaga.christianportal.repositories;


import com.morinaga.christianportal.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    // This will automatically create a query to fetch all users
   List<User> findAll();

    User findByEmail(String email);

    // Custom query method to delete users by memberId if needed
        @Modifying
        @Transactional
        @Query("DELETE FROM User u WHERE u.member.memberId = :memberId")
         void deleteByMemberId(Long memberId);
}
