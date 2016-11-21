/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelabmvc.calculator;

/**
 *
 * @author apprentice
 */
public class Calculator {

    public static Double Convert(String type, String sourceUnit, String targetUnit, Double amount) {
        double finalAmount = 0;
        double intermediate = 0;
        if (type.equals("Temperature")) {
            if (sourceUnit.equals("Kelvin")) {
                intermediate = amount;

            } else if (sourceUnit.equals("Celsius")) {
                intermediate = amount + 273.15;
            } else if (sourceUnit.equals("Fahrenheit")) {
                intermediate = (amount + 459.67) * 5 / 9;
            }

            if (targetUnit.equals("Kelvin")) {
                finalAmount = intermediate;
            } else if (targetUnit.equals("Celsius")) {
                finalAmount = intermediate - 273.15;
            } else if (targetUnit.equals("Fahrenheit")) {
                finalAmount = intermediate * 9 / 5 - 459.67;
            }
        }else if (type.equals("Weight")){
            if(sourceUnit.equals("Pounds")){
                intermediate = amount;
            }else if(sourceUnit.equals("Ounces")){
                intermediate = amount / 16;
            }else if(sourceUnit.equals("Kilograms")){
                intermediate = amount * 2.20462;
            }
            
            if(targetUnit.equals("Pounds")){
                finalAmount = intermediate;
            }else if(targetUnit.equals("Ounces")){
                finalAmount = intermediate * 16;
            }else if(targetUnit.equals("Kilograms")){
                finalAmount = intermediate / 2.20462;
            }
        }else if(type.equals("Time")){
            if(sourceUnit.equals("Minutes")){
                intermediate = amount;
            }else if(sourceUnit.equals("Seconds")){
                intermediate = amount/60;
            }else if(sourceUnit.equals("Hours")){
                intermediate = amount * 60;
            }
            
            if(targetUnit.equals("Minutes")){
                finalAmount = intermediate;
            }else if(targetUnit.equals("Hours")){
                finalAmount = intermediate / 60;
            }else if(targetUnit.equals("Seconds")){
                finalAmount = intermediate * 60;
            }
        }else if(type.equals("Length")){
            if(sourceUnit.equals("Feet")){
                intermediate = amount;
            }else if(sourceUnit.equals("Inches")){
                intermediate = amount / 12;
            }else if(sourceUnit.equals("Meters")){
                intermediate = amount * 3.28084;
            }
            
            if(targetUnit.equals("Feet")){
                finalAmount = intermediate;
            }else if(targetUnit.equals("Inches")){
                finalAmount = intermediate * 12;
            }else if(targetUnit.equals("Meters")){
                intermediate = amount / 3.28084;
            }
        }
        return finalAmount;
    }
}
