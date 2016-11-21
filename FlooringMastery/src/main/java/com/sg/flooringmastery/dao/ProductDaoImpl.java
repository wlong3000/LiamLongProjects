/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ProductDaoImpl implements ProductDao{
    private final String PRODUCTFILE = "products.txt";
    private final String DELIMITER = "::";
    ArrayList<Product> productList = new ArrayList();
    @Override
    public double getLaborCostPerSqFt(String productType) {
        double laborCostPerSqFt = 0;
        for(Product p : productList){
            if(p.getProductType().equals(productType)){
                laborCostPerSqFt = p.getLaborCostPerSqFt();
            }
        }
        return laborCostPerSqFt;
    }

    @Override
    public double getMaterialCostPerSqFt(String productType) {
        double materialCostPerSqFt = 0;
        for(Product p: productList){
            if(p.getProductType().equals(productType)){
                materialCostPerSqFt = p.getMaterialCostPerSqFt();
            }
        }
        return materialCostPerSqFt;
    }

    @Override
    public void save() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(PRODUCTFILE));
            for(Product p : productList){
                writer.println(p.getProductType() + DELIMITER +
                        p.getMaterialCostPerSqFt() + DELIMITER +
                        p.getLaborCostPerSqFt());
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            //do nothing
        }
        
    }

    @Override
    public void load() {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(PRODUCTFILE)));
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] tokens = line.split(DELIMITER);
                
                String productType = tokens[0];
                double materialCostPerSqFt = Double.parseDouble(tokens[1]);
                double laborCostPerSqFt = Double.parseDouble(tokens[2]);
                
                Product newProduct = new Product(productType, materialCostPerSqFt,
                                                laborCostPerSqFt);
                productList.add(newProduct);
            }
        } catch (FileNotFoundException ex) {
            //do nothing
        }
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return productList;
    }
    
}
