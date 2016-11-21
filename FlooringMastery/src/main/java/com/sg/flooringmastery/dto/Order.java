/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

import java.text.NumberFormat;

/**
 *
 * @author apprentice
 */
public class Order {
    private int orderNumber;
    private String customerName;
    private String state;
    private double taxRate;
    private String productType;
    private double area;
    private double materialCostPerSqFt;
    private double laborCostPerSqFt;
    private double materialCost;
    private double laborCost;
    private double tax;
    private double totalCost;
    
    public Order(){
        
    }
    
    public Order(int orderNumber, String customerName, String state, double taxRate,
                    String productType, double area, double materialCostPerSqFt,
                    double laborCostPerSqFt){
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.state = state;
        this.taxRate = taxRate;
        this.productType = productType;
        this.area = area;
        this.materialCostPerSqFt = materialCostPerSqFt;
        this.laborCostPerSqFt = laborCostPerSqFt;
        this.materialCost = materialCostPerSqFt * area;
        this.laborCost = laborCostPerSqFt * area;
        this.tax = taxRate / 100 * (materialCost + laborCost);
        this.totalCost = this.tax + this.materialCost + this.laborCost;
    }
    
    @Override
    public String toString(){
        
        return "Order Number: " + orderNumber + "\nCustomer Name: " + customerName +
                "\nState: " + state + "\nTax Rate: " + taxRate+"%" + "\nProduct Type: " +
                productType + "\nArea: " + area + " Square Feet" + "\nMaterial Cost Per Square Foot: " +
                formatAsMoney(materialCostPerSqFt) + "\nLabor Cost Per Square Foot: " + formatAsMoney(laborCostPerSqFt) +
                "\nMaterial Cost: " + formatAsMoney(materialCost) + "\nLabor Cost: " + formatAsMoney(laborCost) +
                "\nTax: " + formatAsMoney(taxRate) + "\nTotal Cost: " + formatAsMoney(totalCost);
    }
    /**
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the taxRate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the materialCostPerSqFt
     */
    public double getMaterialCostPerSqFt() {
        return materialCostPerSqFt;
    }

    /**
     * @param materialCostPerSqFt the materialCostPerSqFt to set
     */
    public void setMaterialCostPerSqFt(double materialCostPerSqFt) {
        this.materialCostPerSqFt = materialCostPerSqFt;
    }

    /**
     * @return the laborCostPerSqFt
     */
    public double getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    /**
     * @param laborCostPerSqFt the laborCostPerSqFt to set
     */
    public void setLaborCostPerSqFt(double laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    /**
     * @return the materialCost
     */
    public double getMaterialCost() {
        return materialCost;
    }

    /**
     * @param materialCost the materialCost to set
     */
    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    /**
     * @return the laborCost
     */
    public double getLaborCost() {
        return laborCost;
    }

    /**
     * @param laborCost the laborCost to set
     */
    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    /**
     * @return the tax
     */
    public double getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * @return the totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
        public String formatAsMoney(double number){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(number);
    }
}
