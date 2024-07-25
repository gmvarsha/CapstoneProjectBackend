package com.example.userManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userManagement.model.Bookings;
import com.example.userManagement.model.Flight;
import com.example.userManagement.model.User;
import com.example.userManagement.repository.BookingRepository;
import com.example.userManagement.repository.FlightsRepository;
import com.example.userManagement.repository.UserRepository;

@Service(value = "bookingService")
public class BookingService {

	@Autowired
	private FlightsRepository flightsRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookingRepository bookingRepository;

	public List<Bookings> getBookingsByUserId(Long userId) {

		List<Bookings> bookingList = bookingRepository.findByUser_UserId(userId);
		return bookingList;
	}

	public Bookings saveBooking(Long userId, Long long1, Bookings booking) {
		 
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
     
		Flight flight = flightsRepository.findById(long1).orElseThrow(() -> new RuntimeException("Flight not found"));

		booking.setUser(user);
		booking.setFlight(flight);

		return bookingRepository.save(booking);
	}

}
