package com.company.dao;

import com.company.dto.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendingDaoFileImpl implements VendingDao {

    private static final File fileName = new File("Products.csv"); //file with DVD
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

    public void readProducts() {

        try {
            FileReader file = new FileReader(fileName);//reading the file
            BufferedReader lines = new BufferedReader(file);
            String newLine = lines.readLine();
            int i = 1;
            while (newLine != null) { //reading values until end of file is reached
                String[] values = newLine.split(","); // Splits string into an array and store it in

                Product p = new Product(Integer.parseInt(values[0]), values[1], values[2], //creating new DVD object from the file line
                        Integer.parseInt(values[3]));
                allProducts.add(p);
                newLine = lines.readLine();
                i++; //increasing id value
            }
            file.close(); //Closing the file

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(example.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(example.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeFile() {
        /**
         * File Writing Logic
         */
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            //getting values from the array and writing into file with comas to separate values
            for (int i = 0; i < getAllProducts().size(); i++) {
                Product p = getAllProducts().get(i);
                bw.write(p.getId() + ", " + p.getName() + ", " + p.getPrice()
                        + "," + p.getNumber() + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            //Logger.getLogger(example.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
