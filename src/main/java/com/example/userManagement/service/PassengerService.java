package com.example.userManagement.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userManagement.DTO.CheckInStatus;
import com.example.userManagement.model.Bookings;
import com.example.userManagement.model.CheckIn;
import com.example.userManagement.model.Flights;
import com.example.userManagement.model.Passengers;
import com.example.userManagement.model.User;
import com.example.userManagement.model.UserQuery;
import com.example.userManagement.repository.BookingRepository;
import com.example.userManagement.repository.CheckInRepository;
import com.example.userManagement.repository.FlightRepository;
import com.example.userManagement.repository.FlightsRepository;
import com.example.userManagement.repository.PassengerRepository;
import com.example.userManagement.repository.UserQueryRepository;
import com.example.userManagement.repository.UserRepository;

@Service
public class PassengerService {

	@Autowired
    private PassengerRepository passengerRepository;

	 @Autowired
	    private CheckInService checkInService;
	 
    public List<Passengers> getCheckedInPassengers() {
        return passengerRepository.findBycheckedInFlag(true);
    }

    public List<Passengers> getPendingCheckInPassengers() {
        return passengerRepository.findBycheckedInFlag(false);
    }

    public boolean confirmBooking(List<Integer> passengerIds) {
       boolean allCheckedIn= checkInService.checkInPassengers(passengerIds);
       return allCheckedIn;

    }
	/*
	 * public void sendMessage(Integer passengerId, String message) { try { // Find
	 * the passenger by ID Passengers passenger =
	 * passengerRepository.findById(passengerId) .orElseThrow(() -> new
	 * IllegalArgumentException("Passenger not found with ID: " + passengerId));
	 * 
	 * // Prepare the message String recipientEmail = passenger.getEmail(); String
	 * subject = "Flight Check-in Confirmation"; String body = "Dear " +
	 * passenger.getName() + ",\n\n" + message +
	 * "\n\nBest regards,\nFlight Booking Team";
	 * 
	 * // Send the email sendEmail(recipientEmail, subject, body);
	 * 
	 * // Log the successful message sending logger.info("Message sent to {}: {}",
	 * passenger.getName(), message); } catch (Exception e) { // Log the exception
	 * logger.error("Failed to send message to passenger with ID {}: {}",
	 * passengerId, e.getMessage()); // Optionally, you could throw a custom
	 * exception or handle it differently } }
	 */
}

