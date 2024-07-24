package com.flight.userManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flight.userManagement.model.Passengers;
import com.flight.userManagement.service.CheckInService;
import com.flight.userManagement.service.PassengerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/checkedin")
    public ResponseEntity<List<Passengers>> getCheckedInPassengers() {
        return ResponseEntity.ok(passengerService.getCheckedInPassengers());
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Passengers>> getPendingCheckInPassengers() {
        return ResponseEntity.ok(passengerService.getPendingCheckInPassengers());
    }

    @PostMapping("/confirmBooking")
    public ResponseEntity<String> confirmBooking(@RequestBody List<Integer> passengerIds) {
        boolean allCheckedIn= passengerService.confirmBooking(passengerIds);
        if (allCheckedIn) {
            return ResponseEntity.ok("All passengers checked in and booking status moved to COMPLETED.");
        } else {
        	
            return ResponseEntity.ok("Passengers checked in. Booking confirmed and seat assigned");
        }
    }
}
