/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
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
public class TaxDaoImpl implements TaxDao {
    private String TAXFILE = "taxFile.txt";
    private final String DELIMITER = "::";
    private ArrayList<Tax> taxList = new ArrayList();
    @Override
    public ArrayList<Tax> getTaxList() {
       return taxList; 
    }

    @Override
    public double getRate(String state) {
        double rate = 0;
        for(Tax tax : taxList){
            if(tax.getState().equals(state)){
                rate = tax.getTaxRate();
            }
        }
        return rate;
    }

    @Override
    public void load() {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(TAXFILE)));
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] tokens = line.split(DELIMITER);
                
                String state = tokens[0];
                double taxRate = Double.parseDouble(tokens[1]);
                
                Tax newTax = new Tax(state, taxRate);
                taxList.add(newTax);
            }
        } catch (FileNotFoundException fnf) {
            //do nothing
        }
        
    }

    @Override
    public void save() {
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(TAXFILE));
            for(Tax t : taxList){
                writer.println(t.getState() + DELIMITER +
                        t.getTaxRate());
            }
            writer.flush();
            writer.close();
        }catch(IOException ioe){
            //do nothing
        }
    }
    
}
