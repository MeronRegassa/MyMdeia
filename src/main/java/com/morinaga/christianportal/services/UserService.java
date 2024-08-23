package com.morinaga.christianportal.services;

import com.morinaga.christianportal.model.User;
import com.morinaga.christianportal.repositories.UserRegistrationDto;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    User findByEmail(String email);
    User saveUser(User user);

    User registerNewUser(UserRegistrationDto registrationDto);

    boolean checkPassword(String password, String s);

}

