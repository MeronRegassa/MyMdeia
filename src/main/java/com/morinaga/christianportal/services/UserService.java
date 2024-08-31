package com.morinaga.christianportal.services;

import com.morinaga.christianportal.model.User;
import com.morinaga.christianportal.repositories.UserRegistrationDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    User findByEmail(String email);
    User saveUser(User user);
    List<User> getAllUsers();

    User registerNewUser(UserRegistrationDto registrationDto);

    boolean checkPassword(String password, String s);

    @Transactional
    void deleteUserById(Long userId);
}

