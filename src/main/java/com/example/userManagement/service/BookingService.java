package com.example.userManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userManagement.DTO.BookingDTO;
import com.example.userManagement.model.Bookings;
import com.example.userManagement.model.Flights;
import com.example.userManagement.model.User;
import com.example.userManagement.repository.BookingRepository;
import com.example.userManagement.repository.FlightRepository;
import com.example.userManagement.repository.UserRepository;

@Service(value = "bookingService")
public class BookingService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookingRepository bookingRepository;

	public List<BookingDTO> getBookingsByUserId(Long userId) {

		List<BookingDTO> bookingDTO = new ArrayList<>();

		List<Bookings> bookingList = bookingRepository.findByUser_UserId(userId);
		bookingDTO = bookingList.stream().map(booking -> {
			BookingDTO dto = new BookingDTO();
			dto.setBookingId(booking.getBooking_id());
//			dto.setPassengerName(booking.getPassengerName());
			dto.setFlightId(booking.getFlight().getFlightId());
			dto.setFlightNumber(booking.getFlight().getFlightNumber());
			dto.setDepartureAirport(booking.getFlight().getDepartureAirport());
			dto.setArrivalAirport(booking.getFlight().getArrivalAirport());
			dto.setUserId(booking.getUser().getUserId());
//			dto.setUsername(booking.getUser().getUsername());
			return dto;
		}).collect(Collectors.toList());

		return bookingDTO;
	}

	public Bookings saveBooking(Long userId, int flightId, Bookings booking) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		Flights flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));

		booking.setUser(user);
		booking.setFlight(flight);

		return bookingRepository.save(booking);
	}

}
