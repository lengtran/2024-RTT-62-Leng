package org.example;

import org.example.database.dao.ProductsDAO;
import org.example.database.entity.Products;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductMain {

    //i want to be able to search for a product and then change the quantity in stock
    // 1. i need to be able to prompt the user for which product to search for
    // 2. i need to show the products and allow the user to select a product to modify
    // 2.5 we want to find the product for the id the user entered
    // 3. i need to prompt the user to enter the new quantity in stock
    // 4. i need to set the new quantity in stock on the product and save it to the database

    private ProductsDAO productsDAO = new ProductsDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // prompt the user to enter a product name
        String productName = inputProductSearch();

        // use our productDAO to run the query
        List<Products> products = productsDAO.findLikeName(productName);

        //print our product menu
        printProducts(products);

        //now validate that the user enters a propert product id
        Products selectedProduct = null;
        while (selectedProduct == null ) {
            // 2. print the list of products
            printProducts(products);
            int productId = promptForProductId();

            // 2.5 - what happens if the user enters a bad id number that doens't exist
            // we have 2 types of problems here:
            // 1. the user enters a non-numeric value
            // 2.the user enters a numeric id tha doesn't exist in the database
            selectedProduct = productsDAO.findById(productId);
            if (selectedProduct == null) {
                System.out.println("You have entered an invalid product id");
            }
        }


        //3
        int quantity = promptQuantityInStock();
        System.out.println(quantity);

        // 4.
        updateQuantityInStock(selectedProduct, quantity);

        //5.
        System.out.println(selectedProduct);

    }

    public void updateQuantityInStock(Products product, int quantity) {

        product.setQuantityInStock(quantity);
        productsDAO.update(product);

    }

    public int promptQuantityInStock() {
        // really make an effort to try to u/s what is happening here
        // bc you'll need to do this type of error checking on the SBA
        while (true) {
            try {
                System.out.println("Enter the new value for quanitity in stock: ");
                int quantity = scanner.nextInt();
                return quantity;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();

            }
        }
    }

    public void printProducts(List<Products> products) {


        System.out.println("Id  |  Product Name  |  Quantity In Stock");
        System.out.println("=========================================");
        //print out the results of the query
        for (Products product : products) {
            System.out.println(product.getId() + " | " + product.getProductName() + " | " + product.getQuantityInStock());
        }
    }

    public int promptForProductId() {

        while (true) {
            try {
                System.out.println("\nEnter the product id to modify: ");
                int id = scanner.nextInt();
                return id;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }
        }
    }



    public String inputProductSearch() {

        System.out.println("Enter a product name to search for: ");
        String productName = scanner.nextLine();
        return productName;
    }


    public static void main(String[] args) {

        ProductMain pm = new ProductMain();
        pm.run();


    }
}
