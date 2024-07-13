package com.example.userManagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userManagement.model.User;
import com.example.userManagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    

    public User findByEmailAndPassword(String email, String password) {
        // Implement your logic to find user by email and password
        return userRepository.findByEmailAndPassword(email, password);
    }


    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    // Additional methods for user management (create, update, delete) can be added here
}




//import com.example.userManagement.model.User;
//import com.example.userManagement.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public User authenticate(String email, String password, String role) {
//        User user = userRepository.findByEmail(email);
//        if (user != null && passwordEncoder.matches(password, user.getPassword()) && user.getRole().equals(role)) {
//            return user;
//        }
//        return null;
//    }
//
//    public void saveUser(User user) {
//        // Encrypt the password before saving
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//
//    // Add more methods as needed for user management, profile updates, etc.
//}
