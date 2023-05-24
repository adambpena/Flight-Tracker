package com.flightbackend.flightbookingfinal.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.flightbackend.flightbookingfinal.models.UsersFlights;
import com.flightbackend.flightbookingfinal.services.UserAddFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/userFlights")
@CrossOrigin("*")
public class UserAddFlightController {
    
    @Autowired
    UserAddFlightService userAddFlightService;

    @PutMapping("/addFlight")
    @ResponseBody
    public String addFlight(@RequestBody Map<String, String> map) throws StreamReadException, DatabindException, IOException{
        String name = map.get("name");
        String flightId = map.get("flightId");
        return userAddFlightService.userAddFlight(name, flightId);
    }

    @GetMapping("/{username}")
    @ResponseBody
    public List<UsersFlights> showBookedFlights(@PathVariable("username") String username){
        return userAddFlightService.displayUserFlights(username);
    }

    @DeleteMapping("/{userId}")
    @ResponseBody
    public String removeFlight(@PathVariable("userId") String userFlightId){
        return userAddFlightService.flightRemoval(userFlightId);
    }
}
