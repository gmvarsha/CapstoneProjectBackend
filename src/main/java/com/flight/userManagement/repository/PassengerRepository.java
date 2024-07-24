package com.flight.userManagement.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flight.userManagement.DTO.BookingDTO;
import com.flight.userManagement.model.Bookings;
import com.flight.userManagement.model.Passengers;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passengers, Integer> {
    List<Passengers> findBypassengerIdIn(List<Integer> ids);

	List<Passengers> findBybooking_bookingId(Integer bookingId);


    List<Passengers> findBycheckedInFlag(boolean checkedIn);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE PASSENGERS SET checked_in = true WHERE passenger_id = :passengerId", nativeQuery = true)
    void updateCheckinStatus(int passengerId);

}
