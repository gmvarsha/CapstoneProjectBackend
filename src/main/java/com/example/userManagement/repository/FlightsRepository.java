package com.example.userManagement.repository;


import com.example.userManagement.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {

}
