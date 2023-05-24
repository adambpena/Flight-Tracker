package com.flightbackend.flightbookingfinal.services;

import java.util.ArrayList;
import java.util.List;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.flightbackend.flightbookingfinal.models.FlightModel;
import com.flightbackend.flightbookingfinal.repositories.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    private static Amadeus amadeus = Amadeus.builder("ot7oQOp0XyJc3bdFiSyPawJkhgreG442", "DJJGBJqOXGrIAyTs").build();

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<FlightModel> getSearchedFlights(String departingFrom, String arrivingAt, String departureDate, int numOfAdults) throws ResponseException { 
        
        flightRepository.deleteAll();

        List<FlightModel> flightData = new ArrayList<FlightModel>();

        FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
              Params.with("originLocationCode", departingFrom)
                      .and("destinationLocationCode", arrivingAt)
                      .and("departureDate", departureDate)
                      .and("adults", numOfAdults)
                      .and("max", 250));  

        //flightRepository.saveAll(Arrays.asList(flightOffersSearches));
        int counter = 1;
        for(FlightOfferSearch flights : flightOffersSearches){
            flightData.add(new FlightModel(counter++,
                                departingFrom,
                                arrivingAt,
                                flights.isOneWay(), 
                                flights.getLastTicketingDate(), 
                                flights.getNumberOfBookableSeats(), 
                                flights.getItineraries()[0].getSegments().length, 
                                new String(flights.getPrice().getTotal() + " " 
                                + flights.getPrice().getCurrency())));
        }

        flightRepository.saveAll(flightData);

        return flightRepository.findAll();  
    }
    
}
