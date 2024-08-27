package com.morinaga.christianportal.services;

import com.morinaga.christianportal.model.Member;
import com.morinaga.christianportal.model.User;
import com.morinaga.christianportal.repositories.MemberRepository;
import com.morinaga.christianportal.repositories.UserRegistrationDto;
import com.morinaga.christianportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerNewUser(UserRegistrationDto registrationDto) {
        // Check if email is already taken
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByEmail(registrationDto.getEmail()));
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email is already taken");
        }

        // Create a new Member entity
        Member member = new Member();
        member.setFirstName(registrationDto.getFirstName());
        member.setLastName(registrationDto.getLastName());
        member.setEmail(registrationDto.getEmail());
        member.setPhoneNumber(registrationDto.getPhoneNumber());
        member.setServiceRole(registrationDto.getServiceRole());

        // Save the Member entity
        Member savedMember = memberRepository.save(member);

        // Create a new User entity
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword())); // Encrypt the password
        user.setEmail(registrationDto.getEmail());
        user.setMember(savedMember); // Associate the member with the user

        // Save the User entity
        return userRepository.save(user);
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
