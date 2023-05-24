package com.flightbackend.flightbookingfinal.services;

import java.util.List;

import com.amadeus.exceptions.ResponseException;
import com.flightbackend.flightbookingfinal.models.FlightModel;

public interface FlightService {
    List<FlightModel> getSearchedFlights(String departingFrom, String arrivingAt, String departureDate, int numOfAdults) throws ResponseException; 
}
