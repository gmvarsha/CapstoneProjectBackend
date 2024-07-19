package com.example.userManagement.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PASSENGERS")
public class Passengers {
	
	


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passenger_id;// int auto_increment Primary Key,
	private int booking_id;// int ,
	private String first_name;// varchar(50),
	private String last_name;// varchar(50),
	private int passport_number;// int,
	private Date date_of_birth;// date,
	private int seat_number;// int,

	
	//	foreign Key (booking_id) references Bookings(booking_id)
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getPassport_number() {
		return passport_number;
	}
	public void setPassport_number(int passport_number) {
		this.passport_number = passport_number;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public int getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}
	@Override
	public String toString() {
		return "Passengers [passenger_id=" + passenger_id + ", booking_id=" + booking_id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", passport_number=" + passport_number + ", date_of_birth="
				+ date_of_birth + ", seat_number=" + seat_number + "]";
	}

}
