package com.example.userManagement.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKINGS")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
//	@Column(name = "user_id")
//	private Long userId; // BIGINT ,
//	private int flight_id;// int ,
	private Date booking_date;// date,
	private String status; // varchar(50),


	@ManyToOne
	@JoinColumn(name = "flight_id", nullable = false)
	private Flights flight;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	
	public Date getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bookings [booking_id=" + booking_id + ", userId=" +   ", flight_id=" + ", booking_date="
				+ booking_date + ", status=" + status + ", flight=" + flight + "]";
	}

}
