package com.company.service;

import com.company.dto.Product;

import java.util.ArrayList;

public interface VendingServiceLayer {

    ArrayList<Product> getAllProducts();
    ArrayList<Product> getAvailableProducts();
    void isSufficient(int inputAmt, int price);
    void updateInventory(int id);
    void loadProducts();


}
