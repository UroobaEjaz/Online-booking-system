package com.example.demo.Repository.entity;

import jakarta.persistence.*;

@Entity
public class Trains {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int TrainNumber;

    @Column
    private String TrainName;


    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private Users users;

    public Trains(int trainNumber, String trainName, Users users) {
        TrainNumber = trainNumber;
        TrainName = trainName;
        this.users = users;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Trains{" +
                "TrainNumber=" + TrainNumber +
                ", TrainName='" + TrainName + '\'' +
                ", users=" + users +
                '}';
    }
}
