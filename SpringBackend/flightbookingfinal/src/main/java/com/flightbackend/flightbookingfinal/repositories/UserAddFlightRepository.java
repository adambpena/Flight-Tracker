package com.flightbackend.flightbookingfinal.repositories;

import java.util.List;

import com.flightbackend.flightbookingfinal.models.UsersFlights;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddFlightRepository extends JpaRepository<UsersFlights, Integer>{

    @Query(value="SELECT * FROM chosenflightsproto.user_flights WHERE username = :user", nativeQuery=true)
    List<UsersFlights> findByUsername(@Param("user") String user); 

}
