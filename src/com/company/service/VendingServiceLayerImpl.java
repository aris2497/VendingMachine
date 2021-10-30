package com.company.service;

import com.company.dao.VendingDao;
import com.company.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VendingServiceLayerImpl implements VendingServiceLayer {
    VendingDao dao;

    public VendingServiceLayerImpl(VendingDao dao) {
        this.dao = dao;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return (ArrayList<Product>) dao.getAllProducts();

    }

    /**
     * filtering through the array of all products to get only
     * available products to display them to the user
     *
     */
    @Override
    public ArrayList<Product> getAvailableProducts() {

        List<Product> availableProducts = dao.getAllProducts().stream()
                .filter(product -> product.getNumber()>0)
                .collect(Collectors.toList());
        return (ArrayList<Product>) availableProducts;
    }


    @Override
    public void isSufficient(int inputAmt, int price) {
        try {
            if (price > inputAmt) {
                throw new InsufficientFundsException();
            }
        } catch (InsufficientFundsException e) //specific exception first
        {
            e.howtoRecover(inputAmt);
            e.getCause();
        } catch (Exception e) {
            e.getCause();
        }
    }


    @Override
    public void updateInventory(int id) {
        dao.removeProduct(id);
    }

    @Override
    public void loadProducts() {
        dao.readProducts();
    }




    /*
    int pounds = inputAmt / 100;
    int remainder1 = inputAmt % 100;
    int fifties = remainder / 50;
    int remainder2 = remainder1 % 50;
    int twenties = remainder2 / 20;

     */


}
