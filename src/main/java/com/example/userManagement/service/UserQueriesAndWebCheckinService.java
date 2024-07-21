package com.example.userManagement.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userManagement.dto.CheckInRequest;
import com.example.userManagement.dto.QueryRequest;
import com.example.userManagement.model.CheckIn;
import com.example.userManagement.model.Flight;
import com.example.userManagement.model.User;
import com.example.userManagement.model.UserQuery;
import com.example.userManagement.repository.CheckInRepository;
import com.example.userManagement.repository.FlightRepository;
import com.example.userManagement.repository.UserQueryRepository;
import com.example.userManagement.repository.UserRepository;

@Service
public class UserQueriesAndWebCheckinService {

    @Autowired
    private UserQueryRepository userQueryRepository;
    
    @Autowired
    private CheckInRepository checkInRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private FlightRepository flightRepository;
    

    public String saveQuery(QueryRequest queryRequest) throws Exception {
        UserQuery query = new UserQuery();
        query.setUserQueries(queryRequest.getQuery());
        query.setUserId(queryRequest.getUserId());
        query.setCreatedAt(LocalDateTime.now());
        try {
        userQueryRepository.save(query);
        }catch(Exception e) {
        	throw new Exception("Save Query Failed",e);
        }
		return "Query sent successfully! You Will get response within 24hrs";
    }

    public String performCheckIn(CheckInRequest checkInRequest) {
		
		  // Check if the user exists 
  	Optional<User> userOptional =userRepository.findById(checkInRequest.getUserId()); 
  	if (!userOptional.isPresent()) { 
  		throw new
		  IllegalArgumentException("User not found.");
  		}
		  
		  // Check if the flight exists 
  	Optional<Flight> flightOptional = flightRepository.findById(checkInRequest.getFlightId());
  	if (!flightOptional.isPresent()) { 
  		throw new IllegalArgumentException("Flight not found."); }
		  
  	
		  // Check if the user has already checked in for this flight
  	Optional<CheckIn>existingCheckIn = checkInRepository.findByUserIdAndFlightIdAndCheckInDate(checkInRequest.getUserId(),checkInRequest.getFlightId(),checkInRequest.getCheckInDate());
  	if (existingCheckIn.isPresent()) {
  		throw new IllegalStateException("User has already checked in for this flight."); }
		 
      // Perform check-in
      CheckIn checkIn = new CheckIn();
      checkIn.setCheckInTime(LocalDateTime.now());
      checkIn.setFlightId(checkInRequest.getFlightId());
      checkIn.setUserId(checkInRequest.getUserId());
      checkIn.setCheckInDate(checkInRequest.getCheckInDate());
      try {
          checkIn.setStatus("SUCCESS");
      checkInRepository.save(checkIn);
      return "Your web check-in is confirmed. Safe travels!";
      }catch(Exception e) {
          checkIn.setStatus("PENDING");
          checkInRepository.save(checkIn);
          return "Your web check-in is Moved to PENDING. Try after sometime!";
      }
  }

    public List<Map<String,Object>> getAllQueries() {
        return userQueryRepository.getAllQueries();
    }

public List<Map<String, Object>> getQueriesByUserId(Long userId) {
	List<Map<String, Object>> userQueries = userQueryRepository.getQueriesByUserId(userId);
	if(!userQueries.isEmpty()) {
		return userQueries;
	}else {
		return null;
	}      
}
}
