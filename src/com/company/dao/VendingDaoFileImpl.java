package com.company.dao;

import com.company.dto.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingDaoFileImpl implements VendingDao{

    private ArrayList<Product> allProducts = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return allProducts;
    }

    @Override
    public Product getProduct(int id) {
        Product product = allProducts.get(id);
        return product;
    }

    @Override
    public void removeProduct(int id) {
        Product product = allProducts.get(id);
        product.setNumber(product.getNumber() - 1);

    }

    public void readProducts(){
        allProducts.add(new Product(1,"Chocolate", 2, 3));
        allProducts.add(new Product(2, "Candy", 1, 5));
    }

    void writeFile(){

    }
}
