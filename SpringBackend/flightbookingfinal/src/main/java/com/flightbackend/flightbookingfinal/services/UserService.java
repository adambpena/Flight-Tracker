package com.flightbackend.flightbookingfinal.services;

import java.util.List;

import com.flightbackend.flightbookingfinal.models.UserModel;

public interface UserService {

    List<String> userRegistration(String username, String password);

    String userLogin(String username, String password);

    String userRemoval(String id);

    List<UserModel> userDisplay();

}
