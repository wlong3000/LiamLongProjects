/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.util.ArrayList;


/**
 *
 * @author apprentice
 */
public interface ProductDao {
   public ArrayList<Product> getAllProducts();
   public double getLaborCostPerSqFt(String productType);
   public double getMaterialCostPerSqFt(String productType);
   public void save();
   public void load();
}
