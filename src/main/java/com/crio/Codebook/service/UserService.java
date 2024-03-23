package com.crio.Codebook.service;

import java.util.List;

import com.crio.Codebook.dto.ScoreDTO;
import com.crio.Codebook.dto.UserDTO;
import com.crio.Codebook.entity.User;

public interface UserService {
    public List<User> getAllUsers();
    public User getUser(String userId);
    public User saveUser(UserDTO userDTO);
    public User updateUserScore(String userId,ScoreDTO scoreDTO);
    public void removeUser(String userId);
}
