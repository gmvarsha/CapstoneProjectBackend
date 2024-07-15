package com.example.userManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userManagement.model.Bookings;
import com.example.userManagement.model.User;
import com.example.userManagement.repository.BookingRepository;
import com.example.userManagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	BookingRepository bookingRepository;
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

//	public String saveBookingDetails(Bookings booking) {
//
//		try {
//			bookingRepository.save(booking);
////			return "Booking is Succesful for user : " + booking.getUser_id();
//		} catch (Exception e) {
//			return "Error while booking";
//		}
//
//	}



	

	// Additional methods for user management (create, update, delete) can be added
	// here
}
