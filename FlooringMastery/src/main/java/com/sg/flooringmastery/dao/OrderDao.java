/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface OrderDao {
   public void addOrder(Order newOrder);
   public ArrayList<Order> getAllOrders();
   public Order getOrder(int targetNumber);
   public void updateOrder(Order updatedOrder);
   public void removeOrder(Order orderToRemove);
   public int getNumOrders();
   public void load(String date);
   public void save(String date);
}
