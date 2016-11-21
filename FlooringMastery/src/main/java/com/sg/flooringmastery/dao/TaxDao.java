/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface TaxDao {
    public ArrayList<Tax> getTaxList();
    public double getRate(String state);
    public void load();
    public void save();
}
