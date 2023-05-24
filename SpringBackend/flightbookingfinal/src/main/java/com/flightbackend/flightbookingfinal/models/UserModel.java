package com.flightbackend.flightbookingfinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_db",
uniqueConstraints=@UniqueConstraint(columnNames = { "username" })) 
public class UserModel {

    @Id
    private String id; 
    @Column(name="username")
    private String username;
    @Column(name = "password")
    private String password;


    public UserModel() {
    }


    public UserModel(String username, String password) {
        this.id = username + password;
        this.username = username;
        this.password = password;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
