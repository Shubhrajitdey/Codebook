package com.crio.Codebook.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.crio.Codebook.entity.enums.Badge;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Document(collection ="users")
public class User {
    @Id
    private String userId;
    private String username;
    private int score;
    private List<Badge> badges;
    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
        this.score=0;
        this.badges = new ArrayList<>();
    } 

    
}
