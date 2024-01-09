package com.Train.TrainMicroservice.Repository;

import com.Train.TrainMicroservice.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long> {

    Train findByTrainNumber(int trainNumber);
}
