package com.example.userManagement.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="flight_id")
    private Long flightId;
    private String source;
    private String destination;  
    @Column(name ="flight_number")
    private String flightNumber;
    @Column(name ="departure_date")
    private LocalDate departureDate;
    @Column(name ="departure_time")
    private LocalTime departureTime;
    @Column(name ="arrival_date")
    private LocalDate arrivalDate;
    @Column(name ="arrival_time")
    private LocalTime arrivalTime;
    private BigDecimal price;
    private Long seats;
    @Column(name ="flight_type")
    private String flightType;
    private String stops;
    
//    
//    flight_id INT PRIMARY KEY AUTO_INCREMENT,
//    source VARCHAR(255) NOT NULL,
//    destination VARCHAR(255) NOT NULL,
//flight_number VARCHAR(50) NOT NULL,
//departure_date DATE NOT NULL,
//departure_time TIME NOT NULL,
//arrival_date DATE NOT NULL,
//arrival_time TIME NOT NULL,
//stops varchar(255),
//seats int,
//flight_type varchar(50),
//price DECIMAL(10, 2) NOT NULL
    

	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
	private List<Bookings> bookings;
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public String getStops() {
		return stops;
	}
	public void setStops(String stops) {
		this.stops = stops;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getSeats() {
		return seats;
	}
	public void setSeats(Long seats) {
		this.seats = seats;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
    
}


