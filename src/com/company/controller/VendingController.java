package com.company.controller;

import com.company.service.Change;
import com.company.service.VendingServiceLayer;
import com.company.view.VendingView;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author paulina
 */

public class VendingController {
    VendingView view;
    VendingServiceLayer service;

    public VendingController(VendingView view, VendingServiceLayer service) {
        this.view = view;
        this.service = service;
    }
     public void run(){
        service.loadProducts(); //reading from the file
        while(!view.printAvailableItems(service.getAvailableProducts()).equals("x")){
            String inputAmt = view.readInputAmt(); //reading the value of entered money
            int selected = view.getSelectedProduct() - 1; //array indexing starting from 0
            String selectedPrice = service.getAllProducts().get(selected).getPrice();
            service.isSufficient(inputAmt, selectedPrice); //checking if the amount of money is less then selected product price
            BigDecimal change = Change.calculateChange(inputAmt, selectedPrice);
            ArrayList<String> coins = Change.calculateReminder(change); //getting number of coins
            view.toStringCoins(coins.get(0), coins.get(1), coins.get(2), //displaying change in coins
                    coins.get(3));
            service.updateInventory(selected); //updating the number of available product
        }
        service.saveProducts(); //writing to the file
     }
}
