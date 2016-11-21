/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {

    Scanner sc = new Scanner(System.in);

    public void print(String prompt) {
        System.out.println(prompt);
    }

    public String promptForString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.println(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number");
            sc.nextLine();
        }
        int integer = sc.nextInt();
        return integer;
    }
    
    public int promptForIntWithinRange(String prompt, int min, int max){
        System.out.println(prompt);
        int number = sc.nextInt();
        while(number > max || number < min){
            System.out.println("Please enter a number between " 
            + min + " and " + max);
            number = sc.nextInt();
    }
        return number;
    }
    
    public float promptForFloat(String prompt){
        System.out.println(prompt);
        return sc.nextFloat();
    }
    
    public float promptForFloatWithinRange(String prompt, float min, float max){
        System.out.println(prompt);
        float number = sc.nextFloat();
        while(number > max || number < min){
            System.out.println("Please enter a number between " 
            + min + " and " + max);
            number = sc.nextFloat();
    }
        return number;
    }
    
    public double promptForDouble(String prompt){
        System.out.println(prompt);
        return sc.nextDouble();
    }
    
    public double promptForDoubleWithinRange(String prompt, double min,
            double max){
        System.out.println(prompt);
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid number");
            sc.nextLine();
        }
        double number = sc.nextDouble();
        while(number > max || number < min){
            System.out.println("Please enter a number between "
            + min + " and  " + max);
            number = sc.nextDouble();
        }
        return number;
    }

    public String promptForYesNo(String prompt) {
        String choice = promptForString(prompt).toLowerCase();
        while(!choice.equals("y") && !choice.equals("n")
                && !choice.equals("yes") && !choice.equals("no")){
            choice = promptForString("Please enter yes or no (Y/N): ").toLowerCase();
        }
        return choice;
    }
}