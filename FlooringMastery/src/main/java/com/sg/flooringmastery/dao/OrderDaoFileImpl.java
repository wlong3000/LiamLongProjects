/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
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
public class OrderDaoFileImpl implements OrderDao {

    private ArrayList<Order> orderList = new ArrayList();
    private String workingFileName = "";
    private final String DELIMITER = "::";

    @Override
    public void addOrder(Order newOrder) {
        orderList.add(newOrder);
    }

    @Override
    public ArrayList<Order> getAllOrders() {
        return orderList;
    }

    @Override
    public Order getOrder(int targetNumber) {
        
        Order targetOrder = new Order();
        for (Order order : orderList) {
            if (order.getOrderNumber() == targetNumber) {
                targetOrder = order;
            }
        }
        return targetOrder;
    }

    @Override
    public void updateOrder(Order updatedOrder) {
        int targetNumber = updatedOrder.getOrderNumber();
        Order oldOrder = getOrder(targetNumber);
        removeOrder(oldOrder);
        addOrder(updatedOrder);
    }

    @Override
    public void removeOrder(Order orderToRemove) {
        orderList.remove(orderToRemove);
    }

    @Override
    public void load(String date) {
        try {
            loadFromFile(date);
        } catch (FileNotFoundException fnf) {
                //do nothing
        }
    }

    @Override
    public void save(String date) {
            try{
                saveToFile(date);
            }catch(IOException ioe){
                //do nothing
            }
    }

    public void loadFromFile(String date) throws FileNotFoundException {
        workingFileName = "Orders_" + date + ".txt";
        orderList.clear();
        Scanner sc = new Scanner(new BufferedReader(new FileReader(workingFileName)));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] tokens = line.split(DELIMITER);

            int orderNumber = Integer.parseInt(tokens[0]);
            String customerName = tokens[1];
            String state = tokens[2];
            double taxRate = Double.parseDouble(tokens[3]);
            String productType = tokens[4];
            double area = Double.parseDouble(tokens[5]);
            double materialCostPerSqFt = Double.parseDouble(tokens[6]);
            double laborCostPerSqFt = Double.parseDouble(tokens[7]);
            
            Order newOrder = new Order(orderNumber, customerName, state, taxRate,
                                        productType, area, materialCostPerSqFt,
                                        laborCostPerSqFt);
            orderList.add(newOrder);
        }
        sc.close();
    }

    public void saveToFile(String date) throws IOException {
        workingFileName = "Orders_" + date + ".txt";

        PrintWriter writer = new PrintWriter(new FileWriter(workingFileName));
        for (Order o : orderList) {
            writer.println(o.getOrderNumber() + DELIMITER
                    + o.getCustomerName() + DELIMITER
                    + o.getState() + DELIMITER
                    + o.getTaxRate() + DELIMITER
                    + o.getProductType() + DELIMITER
                    + o.getArea() + DELIMITER
                    + o.getMaterialCostPerSqFt() + DELIMITER
                    + o.getLaborCostPerSqFt());
        }
        writer.flush();
        writer.close();
    }
    public int getNumOrders(){
        return orderList.size();
    }
}
