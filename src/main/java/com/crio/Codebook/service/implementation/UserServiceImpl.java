package com.crio.Codebook.service.implementation;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crio.Codebook.dto.ScoreDTO;
import com.crio.Codebook.dto.UserDTO;
import com.crio.Codebook.entity.User;
import com.crio.Codebook.entity.enums.Badge;
import com.crio.Codebook.exception.NullParameterException;
import com.crio.Codebook.exception.ScoreNotWithInRangeException;
import com.crio.Codebook.exception.UserAlreadyExistException;
import com.crio.Codebook.exception.UserNotFoundException;
import com.crio.Codebook.repository.UserRepository;
import com.crio.Codebook.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "score"));
    }

    @Override
    public User getUser(String userId) {
        if(userId==null){
            throw new NullParameterException("UserId can't be Null");
        }
        return userRepository.findById(userId).
        orElseThrow(()-> new UserNotFoundException("UserId Not Found"));
       
    }

    @Override
    public void removeUser(String userId) {
        if(userId==null){
            throw new NullParameterException("UserId can't be Null");
        }
        userRepository.findById(userId).
        orElseThrow(()-> new UserNotFoundException("UserId Not Found"));
        userRepository.deleteById(userId);

    }

    @Override
    public User saveUser(UserDTO userDTO) {
        boolean idExists = userRepository.findAll()
                                        .stream()
                                        .anyMatch(existingUser -> existingUser.getUserId().equals(userDTO.getUserId()));
        if(idExists){
            throw new UserAlreadyExistException("User with this UserId already exist");
        }
        User newUser = new User(userDTO.getUserId(),userDTO.getUserName());
        return userRepository.save(newUser); 
    }

    @Override
    public User updateUserScore(String userId, ScoreDTO scoreDTO) {
        if(userId==null){
            throw new NullParameterException("UserId can't be Null");
        }
        User user = userRepository.findById(userId).
        orElseThrow(()-> new UserNotFoundException("UserId Not Found"));

        int score = scoreDTO.getScore();
        if(score<=0 || score>100){
            throw new ScoreNotWithInRangeException("Score must be within 1 to 100");
        }
        user.setScore(score);
        setBadge(user,score);
        return userRepository.save(user);
    }

    private void setBadge(User user, int score) {
        if(score>=60){
            user.setBadges(Arrays.asList(Badge.CODE_MASTER,Badge.CODE_CHAMP,Badge.CODE_NINJA));
        }else if(score>30 && score<60){
            user.setBadges(Arrays.asList(Badge.CODE_CHAMP,Badge.CODE_NINJA));
        }else{
            user.setBadges(Arrays.asList(Badge.CODE_NINJA));
        }
    }  
}
