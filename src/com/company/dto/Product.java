package com.company.dto;

public class Product {
    private int id;
    private String name;
    private String price;
    private int number;

    public Product(int id, String name, String price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
