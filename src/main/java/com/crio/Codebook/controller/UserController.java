package com.crio.Codebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crio.Codebook.dto.ScoreDTO;
import com.crio.Codebook.dto.UserDTO;
import com.crio.Codebook.entity.User;
import com.crio.Codebook.service.UserService;

@RestController
@RequestMapping("/codebook")
public class UserController {
    
    public static final String USER_API_ENDPOINT = "/users";
    @Autowired
    UserService userService;

    @GetMapping(USER_API_ENDPOINT)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> usersList = userService.getAllUsers();
        return new ResponseEntity<>(usersList,HttpStatus.OK);
    }
    @GetMapping(USER_API_ENDPOINT+"/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable("userId") String userId){
        try {
            User user = userService.getUser(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(USER_API_ENDPOINT)
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {

        if (userDTO.getUserId() == null || userDTO.getUserName() == null) {
            return new ResponseEntity<>("Request attributes missing",HttpStatus.BAD_REQUEST);
        }
        try {
            User user=userService.saveUser(userDTO); 
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(USER_API_ENDPOINT+"/{userId}")
    public ResponseEntity<Object> updateUserScore(@PathVariable("userId") String userId,@RequestBody ScoreDTO scoreDTO){
        try {
            User user = userService.updateUserScore(userId,scoreDTO);
            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(USER_API_ENDPOINT+"/{userId}")
    public ResponseEntity<Object> removeUserFromContest(@PathVariable("userId") String userId) {
        try {
            userService.removeUser(userId);
            return new ResponseEntity<>("User successfully removed !",HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
