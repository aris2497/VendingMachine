package com.company.service;

import com.company.dto.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface VendingServiceLayer {

    ArrayList<Product> getAllProducts();
    ArrayList<Product> getAvailableProducts();
    void isSufficient(String inputAmt, String price);
    void updateInventory(int id);
    void loadProducts();
    void saveProducts();


}
