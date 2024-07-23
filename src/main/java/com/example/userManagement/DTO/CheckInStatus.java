package com.example.userManagement.DTO;

import java.util.List;

public class CheckInStatus {
	 private int bookingId;
	    private List<PassengerStatus> passengers;
		public int getBookingId() {
			return bookingId;
		}
		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}
		public List<PassengerStatus> getPassengers() {
			return passengers;
		}
		public void setPassengers(List<PassengerStatus> passengers) {
			this.passengers = passengers;
		}
	    
		 public static class PassengerStatus {
		        private String name;
		        private boolean checkedIn;
		        private int seatNumber;
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public boolean isCheckedIn() {
					return checkedIn;
				}
				public void setCheckedIn(boolean checkedIn) {
					this.checkedIn = checkedIn;
				}
				public int getSeatNumber() {
					return seatNumber;
				}
				public void setSeatNumber(int seatNumber) {
					this.seatNumber = seatNumber;
				}
		        
		        
		    } 
}

