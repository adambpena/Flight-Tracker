package com.flightbackend.flightbookingfinal.services;

import java.util.List;

import com.flightbackend.flightbookingfinal.models.UsersFlights;

public interface UserAddFlightService {
    String userAddFlight(String user, String flightId); 
    List<UsersFlights> displayUserFlights(String username);
    String flightRemoval(String usersFlightId);
}
