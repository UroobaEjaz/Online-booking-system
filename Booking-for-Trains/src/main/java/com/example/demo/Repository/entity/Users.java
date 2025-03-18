package com.example.demo.Repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


import java.util.Date;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Size(min=3, message = "Name should have at least 3 characters or letters")
    private String name;


    @Column(nullable = false)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$",
            message = "Password must contain at least one digit, one lowercase letter, " +
                    "one uppercase letter, one special character, and be between 8 to 20 characters long")
    private String password;

    @Column
    @NotNull
    private String role;


    @Column
    @Temporal(TemporalType.DATE)
    private Date dateOfJourney;


    @Column
    @OneToMany
    @JoinColumn
    private List<Trains> trains;



    public Users(int userId, String name, String password, String role, Date dateOfJourney, List<Trains> trains) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.role = role;
        this.dateOfJourney = dateOfJourney;
        this.trains = trains;
    }

    public Users() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(Date dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public List<Trains> getTrains() {
        return trains;
    }

    public void setTrains(List<Trains> trains) {
        this.trains = trains;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", dateOfJourney=" + dateOfJourney +
                ", trains=" + trains +
                '}';
    }
}

