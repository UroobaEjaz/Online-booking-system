package com.example.demo.Service;

import com.example.demo.Repository.JPA.TrainJpa;
import com.example.demo.Repository.entity.Trains;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {


    private final TrainJpa trainJpa;

    public TrainService(TrainJpa trainJpa) {
        this.trainJpa = trainJpa;
    }

    public Trains addTrains(Trains newTrains){
        return trainJpa.save(newTrains);
    }

    public List<Trains> getAllTrains(){
        return trainJpa.findAll();
    }









}
