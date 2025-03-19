package com.example.demo.Controller;

import com.example.demo.Repository.entity.Trains;
import com.example.demo.Service.TrainService;
import com.example.demo.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainController {

    private TrainService trainService;

    private UserService userService;

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

//    @DeleteMapping("/delete/{id}")
//    public String deleteById(@PathVariable int id){
//        trainService.deleteTrainById(id);
//        return "Train deleted successfully";
//    }



}
