package com.example.userManagement.controller;


import com.example.userManagement.model.Flight;
import com.example.userManagement.repository.FlightRepository;
import com.example.userManagement.service.FlightService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "http://localhost:3000")

public class FlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightRepository flightrep;
    @GetMapping("/getAllflights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();

    }
    @GetMapping("/getflights")
    public List<Flight> getFlightsBySourceAndDestination(@RequestParam String source,
          @RequestParam String destination,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {
    	System.out.println("inside get flights "+departureDate);
    	List<Flight> flights= flightService.searchFlights( source,  destination,departureDate);
    	try {
			System.out.println("list of flights "+new ObjectMapper().writeValueAsString(flights));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return flights;
    }

}
