package com.example.userManagement.DTO;

import java.sql.Date;

import com.example.userManagement.model.Flights;
import com.example.userManagement.model.User;
import com.fasterxml.jackson.annotation.JsonAlias;

public class BookingPostDTO {
	
	
	
	    private User user;
	    private Flights flight;
	    @JsonAlias("booking_date")
	    private Date bookingDate;
	    private String status;
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Flights getFlight() {
			return flight;
		}
		public void setFlight(Flights flight) {
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
