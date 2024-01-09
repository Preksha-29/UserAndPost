package com.Train.TrainMicroservice.Service;

import com.Train.TrainMicroservice.Entity.Train;
import com.Train.TrainMicroservice.Repository.TrainRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrainService {


    @Autowired
    TrainRepository trainRepository;

    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }

    public Train findTrain(int trainNumber) {
        log.info("finding the train using its trainNumber "+trainNumber);
        return trainRepository.findByTrainNumber(trainNumber);
    }
}
