package com.company.controller;

import com.company.service.Change;
import com.company.service.VendingServiceLayer;
import com.company.view.VendingView;

public class VendingController {
    VendingView view;
    VendingServiceLayer service;
    String exit = "";

    public VendingController(VendingView view, VendingServiceLayer service) {
        this.view = view;
        this.service = service;
    }
     public void run(){
        service.loadProducts();
        while(!view.printAvailableItems(service.getAvailableProducts()).equals("x")){
            int inputAmt = view.readInputAmt();
            int selected = view.getSelectedProduct() - 1; //array indexing starting from 0
            int selectedPrice = service.getAllProducts().get(selected).getPrice();
            service.isSufficient(inputAmt, selectedPrice);
            Change.calculateChange(inputAmt, selectedPrice);
            service.updateInventory(selected);

        }


     }
}
