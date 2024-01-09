package com.Train.TrainMicroservice.Repository;

import com.Train.TrainMicroservice.Entity.Post;
import com.Train.TrainMicroservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {


    Post findByPostTitle(String postTitle);

    List<Post> findByUser(User user);
}
