package com.Train.TrainMicroservice.Service;

import com.Train.TrainMicroservice.Entity.User;
import com.Train.TrainMicroservice.Repository.UserRepo;
import com.Train.TrainMicroservice.dto.PostDto;
import com.Train.TrainMicroservice.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ObjectMapper mapper;
    public UserDto createUser(User user){
        User user1=userRepo.save(user);
      //  UserDto userDto=new UserDto();
      //  userDto.setUserFirstName(user1.getUserFirstName());
     //   userDto.setUserPhoneNumber(user1.getUserPhoneNumber());
       UserDto userDto= mapper.convertValue(user1, UserDto.class);
        return userDto;


    }

    public List<UserDto> getAlluser() {
       List<User> users=userRepo.findAll();
     /* User user1= users.get(0);
        UserDto userDto1=new UserDto();
        userDto1.setUserFirstName(user1.getUserFirstName());
        userDto1.setUserPhoneNumber(user1.getUserPhoneNumber());
        User user2=users.get(1);
        UserDto userDto2=new UserDto();
        userDto2.setUserFirstName(user2.getUserFirstName());
        userDto2.setUserPhoneNumber(user2.getUserPhoneNumber());
        User user3=users.get(2);
        UserDto userDto3=new UserDto();
        userDto3.setUserFirstName(user3.getUserFirstName());
        userDto3.setUserPhoneNumber(user3.getUserPhoneNumber());
        User user4=users.get(3);
        UserDto userDto4=new UserDto();
        userDto4.setUserFirstName(user4.getUserFirstName());
        userDto4.setUserPhoneNumber(user4.getUserPhoneNumber());
        List<UserDto> userDto=new ArrayList<>();
        userDto.add(userDto1);
        userDto.add(userDto2);
        userDto.add(userDto3);
        userDto.add(userDto4);*/
     List<UserDto> userDto= users.stream().map(user->mapper.convertValue(user,UserDto.class)).collect(Collectors.toList());
        return userDto;

    }

    public UserDto findSingleUser(String userFirstname) {
        User user1=userRepo.findByUserFirstName(userFirstname);
        UserDto userDto=new UserDto();
        userDto.setUserFirstName(user1.getUserFirstName());
        userDto.setUserPhoneNumber(user1.getUserPhoneNumber());
        return userDto;
    }

    public String delete(String userLastName) {
        User foundUser=userRepo.findByUserLastName(userLastName);
         userRepo.delete(foundUser);
         return "deleted successfully";
    }

    public String deleteAll() {
       userRepo.deleteAll();
        return "deleted successfully";
    }

    public UserDto updateUser(String userFirstName) {
        User user1=userRepo.findByUserFirstName(userFirstName);
        user1.setUserFirstName("Gorige");
        user1.setUserLastName("Preksha");
        User user2=userRepo.save(user1);
        UserDto userDto=new UserDto();
        userDto.setUserFirstName(user2.getUserFirstName());
        userDto.setUserPhoneNumber(user2.getUserPhoneNumber());
        return userDto;
    }


}
