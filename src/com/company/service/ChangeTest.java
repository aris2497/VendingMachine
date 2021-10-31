package com.company.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChangeTest {



    @org.junit.jupiter.api.Test
    void calculateReminderTest() {
        BigDecimal reminder = BigDecimal.valueOf(0.99);
        ArrayList<String> coins = new ArrayList<String>(Arrays.asList("3","2", "0", "4"));
        assertSame(coins, Change.calculateReminder(reminder));
    }


}