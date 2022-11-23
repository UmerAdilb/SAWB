package com.example.demo.exception;

public class VotingForbidden extends RuntimeException{
    public VotingForbidden(String message){
        super(message);
    }

}
