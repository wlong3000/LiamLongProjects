/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;



/**
 *
 * @author apprentice
 */
public class UI {
    ConsoleIO cio = new ConsoleIO();
    public int promptMenuChoice() {
        
        int choice = cio.promptForInt("\nPlease enter one of the following commands:" +
                                      "\n1. Load Orders for a Different Date"+
                "\n2. Place an Order" +"\n3. Display All Orders"
                +"\n4. Edit an Order" + "\n5. Cancel an Order" +
                "\n6. Save" +"\n7. Quit");
        while (choice > 7 || choice < 1){
            choice = cio.promptForInt("Please enter a valid command:");
        }
        cio.promptForString("");
        return choice;
    }

    public String promptForDate() {
        String date = cio.promptForString("Please enter a date (MM/DD/YYYY): ");
        String[] dateArray = date.split("/");
        int month =0;
        int day = 0;
        int year = 0;
        try{
        month = Integer.parseInt(dateArray[0]);
        day = Integer.parseInt(dateArray[1]);
        year = Integer.parseInt(dateArray[2]);
        }catch(ArrayIndexOutOfBoundsException | NumberFormatException ob){
            cio.print("You entered a date with an incorrect format.");
        }
        while(month < 1 || month > 12){
            month = cio.promptForInt("Please enter a valid month (1-12): ");
        }
        while(day < 1 || day >31){
            day = cio.promptForInt("Please enter a valid day (1-31):");
        }
        while(year < 1950 || year > 2050){
            year = cio.promptForInt("Please enter a valid year (1950-2050):");
        }
        date = "" + month + day + year;
        return date;
    }

    public boolean promptToSave() {
        boolean wantToSave = true;
        String response = cio.promptForYesNo("Would you like to save your work? (Y/N)");
        if(response.equals("no") || response.equals("n")){
            wantToSave = false;
        }
        return wantToSave;
    }

    public boolean promptToDelete() {
        boolean wantToDelete = false;
        String response = cio.promptForYesNo("Are you sure you want to cancel this order? (Y/N)");
        if(response.equals("yes") || response.equals("y")){
            wantToDelete = true;
        }
        return wantToDelete;
    }
}
