package com.company.service.Exceptions;

public class NoItemInventoryException extends IllegalArgumentException{
    public void howtoRecover(int noItemIndex) {
        System.out.println("There is not item with index " + noItemIndex + " ..Try again!");
    }
}
