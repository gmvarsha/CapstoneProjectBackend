package com.example.userManagement.service;

import com.example.userManagement.model.Flight;
import com.example.userManagement.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> searchFlights(String source, String destination, LocalDate departureDate) {
        return flightRepository.findBySourceAndDestinationAndDepartureDate(source, destination, departureDate);
    }
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    
}
