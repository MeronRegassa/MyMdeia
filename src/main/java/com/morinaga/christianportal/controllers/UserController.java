package com.morinaga.christianportal.controllers;


import com.morinaga.christianportal.model.User;
import com.morinaga.christianportal.repositories.LoginRequest;
import com.morinaga.christianportal.repositories.UserRegistrationDto;
import com.morinaga.christianportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private  final  PasswordEncoder passwordEncoder;


    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        try {
            User registeredUser = userService.registerNewUser(registrationDto);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
//        // Login logic
//        return ResponseEntity.ok().body("Login successful");
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
//        // Check if user exists by username
//        Optional<User> userOpt = userService.findByUsername(loginRequest.getUsername());
//        if (userOpt.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//
//        User user = userOpt.get();
//
//        // Check if the password matches
////
//        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//
//        // Login successful
//        return ResponseEntity.ok("Login successful");
//    }







  @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
       Optional<User> user = userService.findByUsername(loginRequest.getUsername());

      if (user.isPresent() && userService.checkPassword(loginRequest.getPassword(), user.get().getPassword())) {
           return ResponseEntity.ok().body("Login successful");
       } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
   }
}
