package com.crio.Codebook.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String expMsg){
        super(expMsg);
    }
}
