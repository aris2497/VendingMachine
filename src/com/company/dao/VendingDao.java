package com.company.dao;

import com.company.dto.Product;

import java.util.List;

public interface VendingDao {
    List<Product> getAllProducts();
    Product getProduct(int id);
    void removeProduct(int id);
    void readProducts();

}
