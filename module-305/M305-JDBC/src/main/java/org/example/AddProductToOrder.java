package org.example;

import org.example.database.dao.CustomersDAO;
import org.example.database.dao.OrderDetailsDAO;
import org.example.database.dao.OrdersDAO;
import org.example.database.dao.ProductsDAO;
import org.example.database.entity.Customers;
import org.example.database.entity.OrderDetails;
import org.example.database.entity.Orders;
import org.example.database.entity.Products;
import org.hibernate.query.Order;

public class AddProductToOrder {

    // i want to be able to add a product to an order w the quantity 100

    //1. Load an order from the database by id
    //2. Load a product from the database by id
    //3. Create a new OrderDetail object and add the order and the product
    //4. Save the OrderDetail object to the database

    private OrdersDAO ordersDAO = new OrdersDAO();
    private ProductsDAO productsDAO = new ProductsDAO();
    private OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
    private CustomersDAO customersDAO = new CustomersDAO();


    public void run() {
        //read the order from the database
        Orders order = ordersDAO.findById(10100); // this is referring to the order ID
        System.out.println(order);

        //this line of code will actually make hibernate do the query to get the customer entity and it's going to use
        // the annotions and the FK value from inside the order object to create and execute the query on our behalf w/out us doing anything
        //the following two are doing the same thing
        Customers customer = order.getCustomers();
//        Customers customer1 = customersDAO.findById(order.getCustomerID());

        System.out.println("This order is for the customer with an id = " + customer.getId() + " and name = " + customer.getCustomerName());

        //NOTE - this way of looping over the products is very inefficient on the database bc it runs a lot of queries
        //this same thing could be accomplished w a single custom query that returns columns from multiple levels
        //lets print out the products that are part of this order already
        // this next line of code executes a query to get the order details -- basically it's doing the equivilent of
        // orderDetailsDAO.findByOrderId(order.getId());
        for (OrderDetails od : order.getOrderDetails()) {
            // the next line of code is going to cause hibernate to query the product table
            // essentially doing productDAO.findById(od.getProductId());
            System.out.println(od.getProducts().getProductName() + " | " + od.getQuantityOrdered() + " | " + od.getPriceEach());
        }


        //read the product from the database
        Products product = productsDAO.findById(1); // this is referring to the product ID
        System.out.println(product);

        //set up the order details object w the values i want to save to the database
        //if this query returns an order detail, then it means the product is already part of the order
        //***this is creating a new orderdetail from the product ID if not already exising***
        OrderDetails orderDetails = orderDetailsDAO.findByOrderIdAndProductId(order.getId(), product.getId());
        if (orderDetails == null) {
            //this means the product was not found in the database as part of the order
            //this will insert a new product
            orderDetails = new OrderDetails();
        }

        //create new instance of orderDetail, then add all info into it w each set function
//        OrderDetails orderDetail = new OrderDetails();


        //we want to increase the quantitiy ordered
        //if this is a new orderdetail, the existing quantity ordered will be 0
        // if this is an existing orderdetail, the quantity ordered will already be set
        // in either case, i want to increase the quantity ordered by 1
        if (orderDetails.getQuantityOrdered() == null) {
            orderDetails.setQuantityOrdered(1);
        } else {
            orderDetails.setQuantityOrdered(orderDetails.getQuantityOrdered() + 1);

        }

        orderDetails.setProducts(product);
        orderDetails.setOrders(order);
        orderDetails.setPriceEach(product.getMsrp());
        orderDetails.setOrderLineNumber(1234);

        //officially insert it into the table
        // it is important to know, if the id is null then you need to insert it
        // if the record was found in the database, then the id will not be null so that is how we know it'll update vs insert
        if (orderDetails.getId() == null) {
            orderDetailsDAO.insert(orderDetails);
        } else {
            orderDetailsDAO.update(orderDetails);
        }
//        orderDetailsDAO.insert(orderDetail);


    }

    public static void main(String[] args) {

        AddProductToOrder apto = new AddProductToOrder();
        apto.run();

    }
}