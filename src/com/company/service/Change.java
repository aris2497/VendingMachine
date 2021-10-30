package com.company.service;

import com.company.dto.Coins;

import java.math.BigDecimal;

/**
 *  class that takes the amount of change due to the user (in pennies)
 *  and then calculates the number of quarters, dimes, nickels,
 *  and pennies due back to the user.
 */
public class Change {

    public static void calculateChange(int inputAmt, int selectedPrice) {
        int pounds = inputAmt / 100;
        int remainder1 = inputAmt % 100;
        int fifties = remainder1 / 50;
        int remainder2 = remainder1 % 50;
        int twenties = remainder2 / 20;

    }
}
