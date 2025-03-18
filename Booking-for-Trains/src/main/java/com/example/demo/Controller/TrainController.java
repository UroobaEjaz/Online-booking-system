package com.example.demo.Controller;

import com.example.demo.Repository.entity.Trains;
import com.example.demo.Service.TrainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainController {

    private TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping("/addTrains")
    public Trains addTrains(@RequestBody Trains newTrains){
        return trainService.addTrains(newTrains);
    }

    @GetMapping("/allTrains")
    public List <Trains> viewTrains(){
        return trainService.getAllTrains();
    }
}
