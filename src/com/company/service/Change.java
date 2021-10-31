package com.company.service;

import com.company.dto.Coins;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * class that takes the amount of change due to the user (in pennies)
 * and then calculates the number of quarters, dimes, nickels,
 * and pennies due back to the user.
 */

public class Change {

    public static BigDecimal calculateChange(String inputAmt, String selectedPrice) {
        return toBigDecimal(inputAmt).subtract(toBigDecimal(selectedPrice));
    }

    public static BigDecimal toBigDecimal(String numberStr) {
        BigDecimal number = new BigDecimal(numberStr);
        number.setScale(2, RoundingMode.HALF_UP);
        return number;
    }

    public static ArrayList<String> calculateReminder(BigDecimal reminder) {
        ArrayList<String> coins = null;
        BigDecimal quarters = BigDecimal.valueOf(0);
        BigDecimal dimes = BigDecimal.valueOf(0);
        BigDecimal nickles = BigDecimal.valueOf(0);

        BigDecimal reminderInPennies = reminder.multiply(BigDecimal.valueOf(100));

        if (reminderInPennies.compareTo(BigDecimal.valueOf(Coins.QUARTER.value)) > 0) {
            quarters = calculateCoins(reminderInPennies, Coins.QUARTER);
            reminderInPennies = reminderInPennies.subtract(quarters.multiply(toBigDecimal(Coins.QUARTER.value.toString())));
        }

        if (reminderInPennies.compareTo(BigDecimal.valueOf(Coins.DIME.value)) > 0) {
            dimes = calculateCoins(reminderInPennies, Coins.DIME);
            reminderInPennies = reminderInPennies.subtract(dimes.multiply(toBigDecimal(Coins.DIME.value.toString())));
        }

        if (reminderInPennies.compareTo(BigDecimal.valueOf(Coins.NICKLE.value)) > 0) {
            System.out.println("NICKLES");
            nickles = calculateCoins(reminderInPennies, Coins.NICKLE);
            reminderInPennies = reminderInPennies.subtract(nickles.multiply(toBigDecimal(Coins.NICKLE.value.toString())));
        }

        BigDecimal pennies = reminderInPennies.setScale(0, RoundingMode.DOWN);

        coins.add(quarters.toString());
        coins.add(dimes.toString());
        coins.add(nickles.toString());
        coins.add(pennies.toString());

        return coins;
    }

    public static BigDecimal calculateCoins(BigDecimal reminder, Coins coins) {
        return reminder.divide(toBigDecimal(coins.value.toString()), 0, RoundingMode.DOWN);
    }
}
