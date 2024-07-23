package com.example.userManagement.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.userManagement.DTO.CheckInStatus;
import com.example.userManagement.DTO.QueryRequest;
import com.example.userManagement.model.Bookings;
import com.example.userManagement.model.UserQuery;
import com.example.userManagement.service.CheckInService;
import com.example.userManagement.service.UserQueriesService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")

public class WebCheckInController {

	 @Autowired
	    private CheckInService checkInService;

	    @GetMapping("/checkin/{bookingId}")
	    public ResponseEntity<CheckInStatus> getCheckInStatus(@PathVariable Integer bookingId) {
	        try {
	            CheckInStatus status = checkInService.getCheckInStatus(bookingId);
	            return ResponseEntity.ok(status);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @GetMapping("/getBookingsByUserIDAndStatus")
	    public ResponseEntity<List<Bookings>> getBookings(@RequestParam Integer userId,
	                                                     @RequestParam String status) {
	        List<Bookings> bookings = checkInService.getBookings(userId, status);
	        return ResponseEntity.ok(bookings);
	    }

	    @PostMapping("/checkin")
	    public ResponseEntity<String> checkInPassengers(@RequestBody List<Integer> passengerIds) {
	        boolean allCheckedIn = checkInService.checkInPassengers(passengerIds);
	        if (allCheckedIn) {
	            return ResponseEntity.ok("All passengers checked in and booking status moved to COMPLETED.");
	        } else {
	        	
	            return ResponseEntity.ok("Passengers checked in.");
	        }
	    }
	}