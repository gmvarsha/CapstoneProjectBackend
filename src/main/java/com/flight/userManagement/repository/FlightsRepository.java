package com.flight.userManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.userManagement.model.Flights;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {

}
