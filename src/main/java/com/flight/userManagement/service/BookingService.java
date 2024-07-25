package com.flight.userManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.userManagement.DTO.BookingDTO;
import com.flight.userManagement.model.Bookings;
import com.flight.userManagement.model.Flight;
import com.flight.userManagement.model.Flights;
import com.flight.userManagement.model.Passengers;
import com.flight.userManagement.model.User;
import com.flight.userManagement.repository.BookingRepository;
import com.flight.userManagement.repository.FlightRepository;
import com.flight.userManagement.repository.FlightsRepository;
import com.flight.userManagement.repository.UserRepository;

@Service(value = "bookingService")
public class BookingService {


	@Autowired
	private FlightRepository flightRepository;

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
     
		Flight flight = flightRepository.findById(long1).orElseThrow(() -> new RuntimeException("Flight not found"));

		booking.setUser(user);
		booking.setFlight(flight);

		return bookingRepository.save(booking);

}
}
