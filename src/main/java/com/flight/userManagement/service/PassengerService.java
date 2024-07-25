package com.flight.userManagement.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.userManagement.DTO.CheckInStatus;
import com.flight.userManagement.model.Bookings;
import com.flight.userManagement.model.Flights;
import com.flight.userManagement.model.Passengers;
import com.flight.userManagement.model.User;
import com.flight.userManagement.model.UserQuery;
import com.flight.userManagement.repository.BookingRepository;
import com.flight.userManagement.repository.FlightRepository;
import com.flight.userManagement.repository.FlightsRepository;
import com.flight.userManagement.repository.PassengerRepository;
import com.flight.userManagement.repository.UserQueryRepository;
import com.flight.userManagement.repository.UserRepository;

@Service
public class PassengerService {

	@Autowired
    private PassengerRepository passengerRepository;

	 @Autowired
	    private CheckInService checkInService;
	 
    public List<Passengers> getCheckedInPassengers() {
        return passengerRepository.findBycheckedInFlag(true);
    }

    public List<Passengers> getPendingCheckInPassengers() {
        return passengerRepository.findBycheckedInFlag(false);
    }

    public boolean confirmBooking(List<Integer> passengerIds) {
       boolean allCheckedIn= checkInService.checkInPassengers(passengerIds);
       return allCheckedIn;

    }
}

