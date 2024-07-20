package com.example.userManagement.controller;


import com.example.userManagement.model.Flight;
import com.example.userManagement.repository.FlightRepository;
import com.example.userManagement.service.FlightService;
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
        return flightService.searchFlights( source,  destination,departureDate);
    }

}
