package com.flight.userManagement.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.userManagement.model.CheckIn;



@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {

	Optional<CheckIn> findByUserIdAndFlightIdAndCheckInDate(Long userId, Long flightId, Date date);

}

