package com.company.service;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException{

    public void howtoRecover(String insufficientFunds) {
        System.out.println(insufficientFunds + " is insufficient...Try again!");
    }
}
