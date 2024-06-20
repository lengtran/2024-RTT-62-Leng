package org.example;

import org.example.database.dao.CustomersDAO;
import org.example.database.dao.OrdersDAO;
import org.example.database.entity.Customers;
import org.example.database.entity.Orders;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerMain {

    private Scanner scanner = new Scanner(System.in);
    private CustomersDAO customersDAO = new CustomersDAO();
    private OrdersDAO ordersDAO = new OrdersDAO();
    Integer customerId = promptForCustomerId();


    public int promptForCustomerId() {

        while (true) {
            try {
                System.out.println("Please enter the customer ID: ");
                int id = scanner.nextInt();
                return id;
            } catch (InputMismatchException e) {
                System.out.println("Id not on file, please try again-");
                scanner.nextLine();
            }
        }
    }

    public void printOrders(List<Orders> Orders) {

        System.out.println("For the customer ID of- " + customerId + " the following orders are placed:\n" + "Customer Name | Order Id  |  Order Date  |  Shipped Date");
        System.out.println("=========================================");

        //print out the results of the query
        for (Orders orders : Orders) {

            System.out.println("For the customer ID of- " + customerId + " the following orders are placed:\n" + "Customer Name | Order Id  |  Order Date  |  Shipped Date \n" + "==================================================\n" +  orders.getCustomers().getCustomerName() + " | " + orders.getId() +  " | " + orders.getOrderDate() +  " | " + orders.getShippedDate() + "\n \n");
        }
    }

    public int promptForOrderId() {

        while (true) {
            try {
                System.out.println("Now, please enter an Order ID so that we can update the comment: ");
                int id = scanner.nextInt();
                return id;
            } catch (InputMismatchException e) {
                System.out.println("Id not on file, please try again-");
                scanner.nextLine();
            }
        }
    }



    public void run() {

        List<Orders> customers = ordersDAO.findByCustomerId(customerId);

        printOrders(customers);
        //print our orders
//        printOrders();
//
//        //now validate that the user enters a propert product id
//        Orders orderId = null;
//        while (orderId == null ) {
//            // 2. print the list of products
//            int newOrderId = promptForOrderId();
//
//
//            // 2.5 - what happens if the user enters a bad id number that doens't exist
//            // we have 2 types of problems here:
//            // 1. the user enters a non-numeric value
//            // 2.the user enters a numeric id tha doesn't exist in the database
//            orderId = ordersDAO.findById(newOrderId);
//            if (orderId == null) {
//                System.out.println("You have entered an invalid product id");
//            }
//        }
//
//
//        //3
//        int quantity = promptQuantityInStock();
//        System.out.println(quantity);
//
//        // 4.
//        updateQuantityInStock(selectedProduct, quantity);
//
//        //5.
//        System.out.println(selectedProduct);

    }

    public static void main(String[] args) {

        CustomerMain cm = new CustomerMain();
        cm.run();


    }
}
