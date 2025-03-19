package com.example.demo.Repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Trains {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int TrainNumber;

    @Column
    private String TrainName;


//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "userId") // This is the foreign key in the Trains table referring to Users
//    private Users user;


    public Trains(int trainNumber, String trainName) {
        TrainNumber = trainNumber;
        TrainName = trainName;

    }

    public Trains() {

    }

    public int getTrainNumber() {
        return TrainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        TrainNumber = trainNumber;
    }

    public String getTrainName() {
        return TrainName;
    }


    public void setTrainName(String trainName) {
        TrainName = trainName;


    }



    @Override
    public String toString() {
        return "Trains{" +
                "TrainNumber=" + TrainNumber +
                ", TrainName='" + TrainName + '\'' +
                '}';
    }
}