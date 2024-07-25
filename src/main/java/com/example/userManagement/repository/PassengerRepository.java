package com.example.userManagement.repository;

//import java.util.Collection;
import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.userManagement.model.Passengers;


@Repository
public interface PassengerRepository extends JpaRepository<Passengers, Integer> {
    List<Passengers> findBypassengerIdIn(List<Integer> ids);

	List<Passengers> findBybooking_bookingId(Integer bookingId);

}
