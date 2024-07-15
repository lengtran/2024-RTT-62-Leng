package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    /*
    @Autowired
    private CustomerDAO customerDao;
    */


    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("employee/employee-search");

        log.debug("The user searched for employee: " + search);

        response.addObject("search", search);


        List<Employee> employees = employeeDao.findByFirstnameOrLastname(search);
        response.addObject("employees", employees);

        return response;
    }

    /*

    // New method to list customers for an employee
    @GetMapping("/customer/list")
    public ModelAndView listCustomers(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("employee/customer-list");

        // Fetch employee details
        Employee employee = employeeDao.findById(employeeId).orElse(null);
        response.addObject("employee", employee);

        // Fetch customers associated with this employee using custom HQL query
        List<Customer> customers = customerDao.findCustomersByEmployeeId(employeeId);
        response.addObject("customers", customers);

        return response;
    }
    */


}