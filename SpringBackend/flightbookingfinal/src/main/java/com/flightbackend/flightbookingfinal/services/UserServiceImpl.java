package com.flightbackend.flightbookingfinal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.flightbackend.flightbookingfinal.models.UserModel;
import com.flightbackend.flightbookingfinal.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository userRepository;

    @Override
    public List<String> userRegistration(String username, String password) {

        List<String> returnMessage = new ArrayList<String>();
        
        List<UserModel> currentUsers = userRepository.findByUsername(username);

        if(currentUsers.size() >= 1)
        {
            returnMessage.add("Username taken");
            return returnMessage;
        }

        if(password.length() < 8){
            returnMessage.add("Password must be more than 8 characters.");
        }

        Pattern passCheck = Pattern.compile("(?=.*[A-Z])");
        Matcher match = passCheck.matcher(password);

        if(match.find() == false){
            returnMessage.add("Password missing an uppercase letter.");
        }

        passCheck = Pattern.compile("(?=.*[a-z])");
        match = passCheck.matcher(password);

        if(!match.find()){
            returnMessage.add("Password missing lowercase letter.");
        }

        passCheck = Pattern.compile("(?=.*[@$!%*#?&])");
        match = passCheck.matcher(password);

        if(!match.find()){
            returnMessage.add("Password missing a special character.");
        }
        
        if(returnMessage.isEmpty())
        {
            UserModel newUser = new UserModel(username, password);
            userRepository.save(newUser);
            returnMessage.add("Success");
            return returnMessage;
        }

        else return returnMessage;
    }

    @Override
    public String userLogin(String username, String password) {
        List<UserModel> currentUsers = userRepository.findAll();
        for(UserModel user : currentUsers){

            if(username.equals("admin"))
            {
                if(password.equals("admin"))
                {
                    return "Admin login success";
                }
            }

            else if(username.equals(user.getUsername()))
            {
                if(password.equals(user.getPassword()))
                {
                    return "Login Success";
                }

                else return "Found username, wrong password";
            }
        }
        return "Unsuccessful login";
    }

    @Override
    public String userRemoval(String username){
        List<UserModel> currentUsers = userRepository.findAll();
        String returnString = "";
        for(UserModel user : currentUsers){
            if(username == "admin"){
                return "Cannot remove admin";
            }
            else if(username.equals(user.getUsername())){
                userRepository.deleteById(user.getUsername() + user.getPassword());
                return username + "has been removed.";
            }
        }
        return returnString;
    }

    @Override
    public List<UserModel> userDisplay(){
        List<UserModel> currentUsers = userRepository.findAll();
        return currentUsers;
    }

}
