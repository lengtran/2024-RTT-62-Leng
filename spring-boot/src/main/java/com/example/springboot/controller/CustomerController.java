package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Customer;

import com.example.springboot.database.entity.Order;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/customer") //when you apply everything on this list is applies to everything in this controller
public class CustomerController {

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private OrderDAO orderDao;

    //this URL is going to be localhost:8080/customer/list
    //this is going to give us a list of customers for that employee
    @GetMapping("/list")
    public ModelAndView list(@RequestParam("employeeId") Integer employeeId) {
        ModelAndView response = new ModelAndView("customer/customer-list");

        // Fetch list of customers for that employee
        List<Customer> customers = customerDao.findCustomersByEmployeeId(employeeId);
        log.debug("Fetched customers: {}", customers); // Use log.debug for debugging

        response.addObject("customers", customers);
        response.addObject("employeeId", employeeId); // Add employeeId to the view
        return response;
    }

    @GetMapping("/details")
    public ModelAndView customerDetails(@RequestParam("id") Integer id) {
        ModelAndView response = new ModelAndView("customer/customer-details");

        // Fetch customer details
        Customer customer = customerDao.findCustomerById(id);
        log.debug("Fetched customer details: {}", customer);
        response.addObject("customer", customer);

        // Fetch orders associated with this customer, here we are auto-injecting the order DAO because we want to use it
        List<Order> orders = orderDao.findOrdersByCustomerId(id);
        log.debug("Fetched orders: {}", orders);
        response.addObject("orders", orders);

        return response;
    }
}