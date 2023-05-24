package com.flightbackend.flightbookingfinal.controllers;

import java.util.List;

import com.flightbackend.flightbookingfinal.models.UserModel;
import com.flightbackend.flightbookingfinal.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/userLogin")
    @ResponseBody
    public String userLogin(@RequestBody UserModel newUser){
        String username = newUser.getUsername();
        String userpass = newUser.getPassword();
        return userService.userLogin(username, userpass);
    }

    @PostMapping(value = "/userRegistration")
    @ResponseBody
    public List<String> userRegistration(@RequestBody UserModel newUser){
        String username = newUser.getUsername();
        String userpass = newUser.getPassword();
        return userService.userRegistration(username, userpass); 
    }

    @GetMapping(value="/userRemoval")
    @ResponseBody
    public List<UserModel> userDisplay(){
        return userService.userDisplay();
    }

    @DeleteMapping(value= "/userRemoval/{username}")
    @ResponseBody
    public String userRegistration(@PathVariable("username") String username){ 
        return userService.userRemoval(username);
    }

}
