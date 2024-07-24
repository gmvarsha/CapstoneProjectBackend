package com.flight.userManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.userManagement.DTO.CheckInStatus;
import com.flight.userManagement.model.Bookings;
import com.flight.userManagement.model.Passengers;
import com.flight.userManagement.repository.BookingRepository;
import com.flight.userManagement.repository.PassengerRepository;

@Service
public class CheckInService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private EmailService emailService;

	public CheckInStatus getCheckInStatus(Integer bookingId) {
		Optional<Bookings> bookingOptional = bookingRepository.findBybookingId(bookingId);
		if (bookingOptional.isPresent()) {
			Bookings booking = bookingOptional.get();
			CheckInStatus status = new CheckInStatus();
			status.setBookingId(booking.getBookingId());
			status.setPassengers(booking.getPassengers().stream().map(p -> {
				CheckInStatus.PassengerStatus ps = new CheckInStatus.PassengerStatus();
				ps.setName((p.getFirst_name() + " " + p.getLast_name()));
				ps.setCheckedIn(p.isCheckedInFlag());
				ps.setSeatNumber(p.getSeat_number());
				return ps;
			}).collect(Collectors.toList()));
			return status;
		} else {
			throw new RuntimeException("Booking not found.");
		}
	}

	public boolean checkInPassengers(List<Integer> passengerIds) {
		List<Passengers> passengers = passengerRepository.findBypassengerIdIn(passengerIds);
		passengers.forEach(passenger -> passenger.setCheckedInFlag(true));
		passengerRepository.saveAll(passengers);

		List<Integer> bookingIds = passengers.stream().map(passenger -> passenger.getBooking().getBookingId())
				.distinct().collect(Collectors.toList());
		boolean allBookingsCompleted = true;

		// Iterate through each unique booking ID
		for (Integer bookingId : bookingIds) {
			List<Passengers> allPassengers = passengerRepository.findBybooking_bookingId(bookingId);

			// Check if all passengers in the booking are checked in
			boolean allCheckedIn = allPassengers.stream().allMatch(Passengers::isCheckedInFlag);

			if (allCheckedIn) {
				Bookings booking = allPassengers.get(0).getBooking();
				booking.setStatus("COMPLETED");
				bookingRepository.save(booking);
				// Send email notification
				String email = booking.getUser().getEmail();

				String subject = "Web Check-In Completed";
				String text = "Your web check-in is completed for booking ID: " + bookingId;
				try {
					emailService.sendCheckInNotification(email, subject, text);
				} catch (Exception e) {
					return true;
				}
			} else {
				allBookingsCompleted = false;
			}
		}

		return allBookingsCompleted;
	}

	public List<Bookings> getBookings(Integer userId, String status) {
		return bookingRepository.findByUser_UserIdAndStatus(userId, status);
	}
}
