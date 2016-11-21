/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class Product {
    private String productType;
    private double materialCostPerSqFt;
    private double laborCostPerSqFt;

    public Product(){
        
    }
    public Product(String productType, double materialCostPerSqFt,
            double laborCostPerSqFt){
        this.productType = productType;
        this.materialCostPerSqFt = materialCostPerSqFt;
        this.laborCostPerSqFt = laborCostPerSqFt;
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
}
