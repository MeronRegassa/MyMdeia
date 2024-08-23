package com.morinaga.christianportal.controllers;

import com.morinaga.christianportal.model.User;
import com.morinaga.christianportal.repositories.UserRegistrationDto;
import com.morinaga.christianportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member/register")
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        User user = userService.registerNewUser(registrationDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
