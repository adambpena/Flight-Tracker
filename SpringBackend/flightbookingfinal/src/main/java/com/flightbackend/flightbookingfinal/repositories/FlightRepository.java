package com.flightbackend.flightbookingfinal.repositories;

import com.flightbackend.flightbookingfinal.models.FlightModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightModel, Integer>{

    

}
