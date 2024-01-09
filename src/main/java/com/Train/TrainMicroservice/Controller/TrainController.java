package com.Train.TrainMicroservice.Controller;

import com.Train.TrainMicroservice.Entity.Train;
import com.Train.TrainMicroservice.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("train")
public class TrainController {

    @Autowired
    TrainService trainService;


    @PostMapping("/addTrain")
    public Train addTrain(@RequestBody Train train){

        return trainService.addTrain(train);
    }


    @GetMapping("/findTrain")
    public Train findTrain(@RequestParam int trainNumber){

        return trainService.findTrain(trainNumber);
    }
}
