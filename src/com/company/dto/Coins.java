package com.company.dto;

public enum Coins {
    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
    private int value;
    private Coins(int value) {
        this.value = value;
    }
}
