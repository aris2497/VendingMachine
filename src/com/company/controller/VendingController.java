package com.company.controller;

import com.company.service.Change;
import com.company.service.VendingServiceLayer;
import com.company.view.VendingView;

import java.math.BigDecimal;

public class VendingController {
    VendingView view;
    VendingServiceLayer service;
    String exit = "";

    public VendingController(VendingView view, VendingServiceLayer service) {
        this.view = view;
        this.service = service;
    }
     public void run(){
        service.loadProducts(); //reading from the file
        while(!view.printAvailableItems(service.getAvailableProducts()).equals("x")){
            String inputAmt = view.readInputAmt();
            int selected = view.getSelectedProduct() - 1; //array indexing starting from 0
            String selectedPrice = service.getAllProducts().get(selected).getPrice();
            service.isSufficient(inputAmt, selectedPrice);
            BigDecimal change = Change.calculateChange(inputAmt, selectedPrice);
            Change.calculateReminder(change);
            service.updateInventory(selected);
        }
        service.saveProducts(); //writing to the file
     }
}
