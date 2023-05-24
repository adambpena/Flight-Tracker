package com.flightbackend.flightbookingfinal.services;

import java.util.List;

import com.flightbackend.flightbookingfinal.models.FlightModel;
import com.flightbackend.flightbookingfinal.models.UsersFlights;
import com.flightbackend.flightbookingfinal.repositories.FlightRepository;
import com.flightbackend.flightbookingfinal.repositories.UserAddFlightRepository;
import com.flightbackend.flightbookingfinal.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddFlightServiceImpl implements UserAddFlightService { 

    @Autowired
    UserAddFlightRepository userAddFlightRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FlightRepository flightRepository;

    @Override
    public String userAddFlight(String user, String flightId){
        FlightModel flightAdd = new FlightModel();
        int fId = Integer.parseInt(flightId);
        List<FlightModel> currentFlights = flightRepository.findAll();
        for(FlightModel f : currentFlights){
            if(fId == f.getId()){
                flightAdd = f;
            }
        }

        UsersFlights userFlight = new UsersFlights(user, flightAdd.getDeparting(),
            flightAdd.getArriving(), flightAdd.getIsOneWay(), flightAdd.getLastTicketingDate(), flightAdd.getSeatsLeft(),
            flightAdd.getNumberOfConnectingFlights(), flightAdd.getTotalPrice());

        userAddFlightRepository.save(userFlight);

        return "Flight added!";
    }

    @Override
    public List<UsersFlights> displayUserFlights(String username) {
        return userAddFlightRepository.findByUsername(username);
    }

    @Override
    public String flightRemoval(String usersFlightId) {

        List<UsersFlights> flights = userAddFlightRepository.findAll();
        for(UsersFlights f : flights){
            if(Integer.parseInt(usersFlightId) == f.getId()){
                userAddFlightRepository.deleteById(Integer.parseInt(usersFlightId));;
                return "Flight removed";
            }
        } 

        return "Debug";
    }

    
}
