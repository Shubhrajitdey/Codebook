package com.crio.Codebook.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String expMsg){
        super(expMsg);
    }
}
