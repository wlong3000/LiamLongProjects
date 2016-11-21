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
public class OrderDaoInMemImpl implements OrderDao {
    private ArrayList<Order> orderList = new ArrayList();
    
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
        for(Order order : orderList){
            if(order.getOrderNumber() == targetNumber){
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
    public int getNumOrders(){
        return orderList.size();
    }
    @Override
    public void load(String date) {
        
        }

    @Override
    public void save(String date) {
        
        }
    
}
