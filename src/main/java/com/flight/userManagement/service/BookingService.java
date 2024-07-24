package com.flight.userManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.userManagement.DTO.BookingDTO;
import com.flight.userManagement.model.Bookings;
import com.flight.userManagement.model.Flights;
import com.flight.userManagement.model.Passengers;
import com.flight.userManagement.model.User;
import com.flight.userManagement.repository.BookingRepository;
import com.flight.userManagement.repository.FlightsRepository;
import com.flight.userManagement.repository.UserRepository;

@Service(value = "bookingService")
public class BookingService {

	@Autowired
	private FlightsRepository flightsRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookingRepository bookingRepository;

	public List<Bookings> getBookingsByUserId(Long userId) {

		List<BookingDTO> bookingDTO = new ArrayList<>();

		List<Bookings> bookingList = bookingRepository.findByUser_UserId(userId);
		
		
//		bookingDTO = bookingList.stream().map(booking -> {
//			List<Passengers> passengerList = new ArrayList<>();
//			BookingDTO dto = new BookingDTO();
//			dto.setBookingId(booking.getBooking_id());
//			for (Passengers p : booking.getPassengers()) {
//				
//				passengerList.add(p);
//			}
//			
//			dto.setFlightId(booking.getFlight().getFlightId());
//			dto.setFlightNumber(booking.getFlight().getFlightNumber());
//			dto.setDepartureAirport(booking.getFlight().getSource());
//			dto.setArrivalAirport(booking.getFlight().getDestination());
//			dto.setUserId(booking.getUser().getUserId());
////			dto.setUsername(booking.getUser().getUsername());
//			return dto;
//		}).collect(Collectors.toList());

		return bookingList;
	}

	public Bookings saveBooking(Long userId, Long long1, Bookings booking) {
		  System.out.println("User id "+userId);
		  System.out.println("User id "+userId);
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
     
		Flights flight = flightsRepository.findById(long1).orElseThrow(() -> new RuntimeException("Flight not found"));

		booking.setUser(user);
		booking.setFlight(flight);

		return bookingRepository.save(booking);
	}

}
