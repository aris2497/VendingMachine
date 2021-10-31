package com.company.view;

import com.company.dto.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VendingView {
    UserIO io;
    public VendingView(UserIO io) {
        this.io = io;
    }

    public String printAvailableItems(ArrayList<Product> products){
        io.print("Available Items");

        for (Product product : products) {
            String productInfo = toString(product);
            io.print(productInfo);
        }
        return io.readString("Press [x] to exit the program or press enter to continue.");
    }

    public int getSelectedProduct() {
        return io.readInt("Please select product number",1,20);
    }

    public String toString(Product product) {
        return String.format("#%s %s: %s$, %s items",
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getNumber());
    }

    public String toStringCoins(String quarters, String dimes, String nickles, String pennies){
        return String.format("Quarters: " + quarters.toString() +
                "\nDimes: " + dimes +
                "\nNickles: " + nickles +
                "\nPennies: " + pennies);
    }

    public String readInputAmt() {
        return io.readString("Please enter money before selecting");
    }
}
