package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
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


    @Autowired
    private CustomerDAO customerDao;


    @Autowired
    private OfficeDAO officeDAO;



    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("employee/employee-search");

        log.debug("The user searched for employee: " + search);

        response.addObject("search", search);


        List<Employee> employees = employeeDao.findByFirstnameOrLastname(search);
        response.addObject("employees", employees);

        return response;
    }


    @GetMapping("/create")
    //this method is setting up the view for rendering
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("employee/create");
        // this is for the list of employees who can be selected as reporting employees
        List<Employee> reportsToEmployees = employeeDao.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);
        // This will give us a list of offices from the database

        List<Office> offices = officeDAO.findAll();
        response.addObject("reportsToOffices", offices);
        log.debug(offices.toString());


        return response;

    }

    // this is /employee/createSubmit
    //this method is only called when the form is submitted

    @GetMapping("/createSubmit") //it can get tiring to create request param so we will use Form bean
    public ModelAndView createSubmit(CreateEmployeeFormBean form) {
        // argument to the constrcutor ere is the view name the view name can be a jsp location or a redirect URL
        ModelAndView response = new ModelAndView();

        log.debug(form.toString());

        //setting the incoming user input onto a new employee object to be saved to the database

        Employee employee = new Employee(); //creating a new employee
        employee.setEmail(form.getEmail()); //setting the email, we can hardcode it, but we can save it to our data by
        employee.setFirstname(form.getFirstName());
        employee.setLastname(form.getLastName());
        employee.setReportsTo(form.getReportsTo());
        employee.setExtension(form.getExtension());
        employee.setOfficeId(form.getOfficeId());
        employee.setJobTitle(form.getJobTitle());
        employee.setProfileImageUrl(form.getProfileImageUrl());
        employee.setVacationHours(form.getVacationHours());


        //when we save to database it will auto increment to give us a new id
        //new ID is avlaiable in the return from the save method
        //basically return the same object except after it's been inserted in to the database
        employee = employeeDao.save(employee);
        //this is after the redirect is actually a full url not a view name
        //this is overriding the behavior of the setViewName to use a URl rather than a JSP file location
        response.setViewName("redirect:/employee/detail?employeeId=" + employee.getId());

        return response;

    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("employee/detail");

        List<Customer> customers = customerDao.findCustomersByEmployeeId(employeeId);
        response.addObject("customers", customers);

        Employee employee = employeeDao.findById(employeeId);
        response.addObject("employee", employee);

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