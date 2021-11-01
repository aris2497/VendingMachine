package com.company.service.Exceptions;

public class ZeroFundsException extends Throwable{
    public void howToRecover() {
        System.out.println("0 is invalid. You have enter money to start...Try again!");
    }
}
