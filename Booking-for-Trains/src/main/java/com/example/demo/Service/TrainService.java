package com.example.demo.Service;

import com.example.demo.Repository.JPA.TrainJpa;
import com.example.demo.Repository.entity.Trains;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Trains> getTrainById(int trainNumber) {
        return Optional.ofNullable(trainJpa.findById(trainNumber).orElse(null));
    }

    public void deleteTrainById(int id){
        trainJpa.deleteById(id);
    }










}
