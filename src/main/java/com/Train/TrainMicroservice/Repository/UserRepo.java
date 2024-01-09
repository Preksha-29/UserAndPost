package com.Train.TrainMicroservice.Repository;

import com.Train.TrainMicroservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUserFirstName(String userFirstname);

    User findByUserLastName(String userLastName);
}
