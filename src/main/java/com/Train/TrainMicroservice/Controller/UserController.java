package com.Train.TrainMicroservice.Controller;

import com.Train.TrainMicroservice.Entity.User;
import com.Train.TrainMicroservice.Service.UserService;
import com.Train.TrainMicroservice.dto.PostDto;
import com.Train.TrainMicroservice.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public UserDto createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @GetMapping("/getusers")
    public List<UserDto> getAlluser() {
        return userService.getAlluser();
    }

    @GetMapping("/singleUser")
    public UserDto findSingleUser(@RequestParam String userFirstname) {
        return userService.findSingleUser(userFirstname);
    }

    /* @GetMapping("/singleUserByPathVariable/{userFirstName}")
     public User findSingleUserUsingPathVariable(@PathVariable("userFirstname") String userFirstname) {
         return userService.findSingleUser(userFirstname);
     }*/
    @DeleteMapping("/deleteUser")
    public String deleteUserlastName(@RequestParam String userLastName) {
        return userService.delete(userLastName);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        return userService.deleteAll();
    }

    @PatchMapping("/updateUser")
    public UserDto updateUser(@RequestParam String userFirstName) {
        return userService.updateUser(userFirstName);
    }


}
