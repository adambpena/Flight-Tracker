package com.flightbackend.flightbookingfinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userFlights")
public class UsersFlights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "Departing")
    public String departing;
    @Column(name = "Arriving")
    public String arriving;
    @Column(name = "Oneway")
    private boolean isOneWay;
    @Column(name= "LastTicketingDate")
    private String lastTicketingDate;
    @Column(name="Seats_Left")
    private int seatsLeft;
    @Column(name = "NumConnecting")
    private int numberOfConnectingFlights;
    @Column(name = "Total_Price")
    private String totalPrice; 


    public UsersFlights() {
    }


    public UsersFlights(String username, String departing, String arriving, boolean isOneWay, String lastTicketingDate, int seatsLeft, int numberOfConnectingFlights, String totalPrice) {
        this.username = username;
        this.departing = departing;
        this.arriving = arriving;
        this.isOneWay = isOneWay;
        this.lastTicketingDate = lastTicketingDate;
        this.seatsLeft = seatsLeft;
        this.numberOfConnectingFlights = numberOfConnectingFlights;
        this.totalPrice = totalPrice;
    }
    

    public int getId() {
        return this.id;
    }

    public void setUserId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeparting() {
        return this.departing;
    }

    public void setDeparting(String departing) {
        this.departing = departing;
    }

    public String getArriving() {
        return this.arriving;
    }

    public void setArriving(String arriving) {
        this.arriving = arriving;
    }

    public boolean isIsOneWay() {
        return this.isOneWay;
    }

    public boolean getIsOneWay() {
        return this.isOneWay;
    }

    public void setIsOneWay(boolean isOneWay) {
        this.isOneWay = isOneWay;
    }

    public String getLastTicketingDate() {
        return this.lastTicketingDate;
    }

    public void setLastTicketingDate(String lastTicketingDate) {
        this.lastTicketingDate = lastTicketingDate;
    }

    public int getSeatsLeft() {
        return this.seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public int getNumberOfConnectingFlights() {
        return this.numberOfConnectingFlights;
    }

    public void setNumberOfConnectingFlights(int numberOfConnectingFlights) {
        this.numberOfConnectingFlights = numberOfConnectingFlights;
    }

    public String getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
