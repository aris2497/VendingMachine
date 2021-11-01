package com.company.service.Exceptions;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException{


    public void howtoRecover(String inputAmt) {
        System.out.println(inputAmt + " is insufficient...Try again!");
    }
}
