package com.crio.Codebook.exception;

public class ScoreNotWithInRangeException extends RuntimeException{
    public ScoreNotWithInRangeException(String expMsg){
        super(expMsg);
    }
}
