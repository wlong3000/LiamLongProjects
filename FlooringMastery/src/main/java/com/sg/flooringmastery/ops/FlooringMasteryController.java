/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ops;

import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dao.ProductDaoImpl;
import com.sg.flooringmastery.dao.TaxDaoImpl;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.ui.ConsoleIO;
import com.sg.flooringmastery.ui.UI;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryController {

    private OrderDao myOrder;
    ProductDaoImpl myProduct = new ProductDaoImpl();
    TaxDaoImpl myTax = new TaxDaoImpl();
    UI ui = new UI();
    ConsoleIO cio = new ConsoleIO();

    public FlooringMasteryController(OrderDao dao) {
        this.myOrder = dao;
    }

    public void run() {
        //get local time and set it to the workingDate
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int year = now.getYear();
        String workingDate = "" + month + day + year;
        cio.print("\nThe current date is " + month + "/" + day + "/" + year);

        myOrder.load(workingDate);
        myProduct.load();
        myTax.load();

        int command = 0;

        while (command != 7) {
            command = ui.promptMenuChoice();
            switch (command) {
                case 1:
                    boolean wantToSave = ui.promptToSave();
                    if (wantToSave) {
                        myOrder.save(workingDate);
                        cio.print("Your work has been saved.\n");
                    }
                    //set date
                    workingDate = ui.promptForDate();
                    myOrder.load(workingDate);
                    break;
                case 2:
                    //add order
                    addOrder(workingDate);
                    break;
                case 3:
                    //display all orders
                    displayAllOrders(workingDate);
                    break;
                case 4:
                    //edit an order
                    editOrder();
                    break;
                case 5:
                    //cancel an order
                    cancelOrder();
                    break;
                case 6:
                    myOrder.save(workingDate);
                    cio.print("Your work has been saved.\n");
                    break;
                case 7:
                    //prompt to save
                    wantToSave = ui.promptToSave();
                    if (wantToSave) {
                        myOrder.save(workingDate);
                        cio.print("Your work has been saved.\n");
                    }
                //quit program
                default:
                    break;
            }
        }
        myProduct.save();
        myTax.save();
    }

    private void displayAllOrders(String workingDate) {
        ArrayList<Order> orderList = myOrder.getAllOrders();
        if (orderList.isEmpty()) {
            cio.print("Unable to find any orders for the date " + workingDate);
        } else {
            cio.print("Printing Order List:");
            for (Order o : orderList) {
                cio.print("-----------------------------------");
                cio.print(o.toString());
            }
            cio.print("-----------------------------------");
        }
    }

    private void addOrder(String workingDate) {
        ArrayList<Tax> taxList = myTax.getTaxList();
        ArrayList<Product> productList = myProduct.getAllProducts();
        //generate orderNumber automatically
        int orderNumber = myOrder.getNumOrders() + 1;
        //prompt user for name
        String customerName = cio.promptForString("Customer Name: ");
        if (customerName.equals("")) {
            customerName = cio.promptForString("Please enter a name:");
        }
        //prompt user for state then validate
        String state = cio.promptForString("State (initials): ");
        state = state.toUpperCase();
        state = validateState(state);
        if (!state.equals("CANCEL")) {
            double taxRate = 0;
            for (Tax t : taxList) {
                if (t.getState().equals(state)) {
                    taxRate = t.getTaxRate();
                }
            }
            //prompt user for product then validate
            String productType = cio.promptForString("Product Type: ").toLowerCase();
            productType = validateProductType(productType);
            if (!productType.equals("cancel")) {
                double materialCostPerSqFt = 0;
                double laborCostPerSqFt = 0;
                for (Product p : productList) {
                    if (p.getProductType().toLowerCase().equals(productType)) {
                        materialCostPerSqFt = p.getMaterialCostPerSqFt();
                        laborCostPerSqFt = p.getLaborCostPerSqFt();
                    }
                }
                //prompt user for area
                double area = cio.promptForDoubleWithinRange("Area: ", 0, 999999999);
                //generate order and display info
                Order newOrder = new Order(orderNumber, customerName, state,
                        taxRate, productType, area, materialCostPerSqFt,
                        laborCostPerSqFt);
                cio.print("Order Information:");
                cio.print(newOrder.toString());
                //ask user to confirm order
                String wantToSave = cio.promptForYesNo("Would you like to confirm your order?");
                if (wantToSave.equals("y") || wantToSave.equals("yes")) {
                    myOrder.addOrder(newOrder);
                    myOrder.save(workingDate);
                }
            }
        }
    }

    public String validateState(String state) {
        ArrayList<Tax> taxList = myTax.getTaxList();
        boolean valid = false;
        for (Tax tax : taxList) {
            if (tax.getState().equals(state)) {
                valid = true;
            }
        }
        while (!valid) {
            state = cio.promptForString("Our services are not currently offered in that "
                    + "state. \nPlease re-enter your state or type 'cancel' to cancel your order.");
            state = state.toUpperCase();
            for (Tax tax : taxList) {
                if (tax.getState().equals(state)) {
                    valid = true;
                }
            }
            if (state.equals("CANCEL")) {
                valid = true;
            }
        }
        return state;
    }

    public String validateProductType(String productType) {
        ArrayList<Product> productList = myProduct.getAllProducts();;
        //validate
        boolean valid = false;
        for (Product p : productList) {
            if (p.getProductType().toLowerCase().equals(productType.toLowerCase())) {
                valid = true;
            }
        }
        while (!valid) {
            productType = cio.promptForString("That product is not currently offered: "
                    + "\nPlease re-enter a product type or enter 'cancel' to cancel your order:");
            for (Product p : productList) {
                if (p.getProductType().toLowerCase().equals(productType.toLowerCase())) {
                    valid = true;
                }
            }
            if (productType.toLowerCase().equals("cancel")) {
                valid = true;
            }
        }
        return productType;
    }

    private void cancelOrder() {
        ArrayList<Order> orderList = myOrder.getAllOrders();
        int targetNumber = cio.promptForInt("Please enter the order number:");
        Order targetOrder = myOrder.getOrder(targetNumber);
        if (targetOrder.getCustomerName() == null) {
            cio.print("Unable to find that order");
        } else {
            cio.print(targetOrder.toString());
            boolean wantToDelete = ui.promptToDelete();
            if (wantToDelete) {
                myOrder.removeOrder(targetOrder);
                cio.print("The order has been canceled.");
            }
        }
    }

    private void editOrder() {
        ArrayList<Order> orderList = myOrder.getAllOrders();
        ArrayList<Tax> taxList = myTax.getTaxList();
        ArrayList<Product> productList = myProduct.getAllProducts();
        String productType ="";
        //find order
        int targetNumber = cio.promptForInt("Please enter the order number:");
        Order oldOrder = myOrder.getOrder(targetNumber);
        if (targetNumber > orderList.size() || targetNumber < 1) {
            cio.print("Unable to find that order");
        } else {
            //update order
            cio.print("Please enter new information to update each field, "
                    + "\nor leave the field blank to keep the old information.");
            cio.promptForString("");
            String customerName = cio.promptForString("Customer name (" + oldOrder.getCustomerName()
                    + "): ");
            if (customerName.equals("")) {
                customerName = oldOrder.getCustomerName();
            }
            //either keep the old state, enter a new one, or cancel
            String state = cio.promptForString("State (" + oldOrder.getState() + "): ").toUpperCase();
            if (state.equals("")) {
                state = oldOrder.getState();
            }
            state = validateState(state);
            if (!state.equals("CANCEL")) {
                if (state.equals("")) {
                    state = oldOrder.getState();
                }
                double taxRate = 0;
                for (Tax t : taxList) {
                    if (t.getState().equals(state)) {
                        taxRate = t.getTaxRate();
                    }
                }
                //either keep the old product, enter a new one, or cancel
                productType = cio.promptForString("Product (" + oldOrder.getProductType() + "): ");
                if (productType.equals("")) {
                    productType = oldOrder.getProductType();
                }
                productType = validateProductType(productType);
                if (!productType.equals("cancel")) {
                    if (productType.equals("")) {
                        productType = oldOrder.getProductType();
                    }
                    double materialCostPerSqFt = 0;
                    double laborCostPerSqFt = 0;
                    for (Product p : productList) {
                        if (p.getProductType().toLowerCase().equals(productType)) {
                            materialCostPerSqFt = p.getMaterialCostPerSqFt();
                            laborCostPerSqFt = p.getLaborCostPerSqFt();
                        }
                    }
                    //either keep the old area or enter a new one
                    String areaString = cio.promptForString("Area (" + oldOrder.getArea() + "): ");
                    double area = 0;
                    if (areaString.equals("")) {
                        area = oldOrder.getArea();
                    } else {
                        try {
                            area = Double.parseDouble(areaString);
                        } catch (NumberFormatException nfe) {
                            area = cio.promptForDoubleWithinRange("Please enter a valid number: ", 0, 99999999);
                        }
                    }
                    //update order list and ask user to confirm changes
                    Order newOrder = new Order(oldOrder.getOrderNumber(), customerName, state,
                            taxRate, productType, area, materialCostPerSqFt,
                            laborCostPerSqFt);
                    cio.print("Order Information:");
                    cio.print(newOrder.toString());
                    String wantToSave = cio.promptForYesNo("Would you like to confirm these changes? (Y/N)");
                    if (wantToSave.equals("y") || wantToSave.equals("yes")) {
                        myOrder.updateOrder(newOrder);
                    }
                }
            }
            if (state.equals("CANCEL") || productType.equals("cancel")) {
                boolean wantToDelete = ui.promptToDelete();
                if (wantToDelete) {
                    myOrder.removeOrder(oldOrder);
                    cio.print("The order has been canceled.");
                }
            }
        }
    }
}
