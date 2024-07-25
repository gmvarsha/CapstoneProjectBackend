package com.flight.userManagement.DTO;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.flight.userManagement.model.Flight;
import com.flight.userManagement.model.Passengers;
import com.flight.userManagement.model.User;


public class BookingPostDTO {
	
	
	    private User user;
	    private Flight flight;
	    @JsonAlias("booking_date")
	    private Date bookingDate;
	    private String status;
	    private List<Passengers> passengerDetails;
	    
	    
		
	 

		public List<Passengers> getPassengerDetails() {
			return passengerDetails;
		}

		public void setPassengerDetails(List<Passengers> passengerDetails) {
			this.passengerDetails = passengerDetails;
		}

		public User getUser() {
			return user;
		}
	    
		public void setUser(User user) {
			this.user = user;
		}
		public Flight getFlight() {
			return flight;
		}
		public void setFlight(Flight flight) {
			this.flight = flight;
		}
		public Date getBookingDate() {
			return bookingDate;
		}
		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

	    // Getters and setters
	

}
