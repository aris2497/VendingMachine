package com.company.dto;

public enum Coins {
    PENNY(1.0), NICKLE(5.0), DIME(10.0), QUARTER(25.0);
    public Double value;

    private Coins(Double value) {
        this.value = value;
    }
}
