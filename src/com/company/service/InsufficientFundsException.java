package com.company.service;

public class InsufficientFundsException extends RuntimeException{

    public void howtoRecover(int insufficientFunds) {
        System.out.println(insufficientFunds + " is insufficient...Try again!");
    }
}
