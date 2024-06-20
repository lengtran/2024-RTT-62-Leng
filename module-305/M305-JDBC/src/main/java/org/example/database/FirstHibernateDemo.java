package org.example.database;

import org.example.database.dao.CustomersDAO;
import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Customers;
import org.example.database.entity.Employee;

import java.util.List;
import java.util.Scanner;

public class FirstHibernateDemo {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CustomersDAO customersDAO = new CustomersDAO();


//        Customers newCustomer = new Customers();
//
//        newCustomer.setCustomerName("Pet Groomer");
//        newCustomer.setContactLastName("Doezy");
//        newCustomer.setContactFirstName("Janey");
//        newCustomer.setPhone("123-456-7891");
//        newCustomer.setAddress1("3456 Mainey St");
//        newCustomer.setAddress2("");
//        newCustomer.setCity("Sequina");
//        newCustomer.setState("Maryland");
//        newCustomer.setZipCode("75846");
//        newCustomer.setCountry("USofA");
//
//        customersDAO.insert(newCustomer);



//        //lets create a new employee in the database
//        Employee newEmployee = new Employee();
//
//
//        newEmployee.setFirstName("First NAME!*!*");
//        newEmployee.setLastName("LAstName");
//        newEmployee.setEmail("123@gmail.com");
//        newEmployee.setOfficeId(3);
//        newEmployee.setExtension("12345");
//        newEmployee.setJobTitle("newbie");
//        newEmployee.setVacationHours(0);
//
//
//        employeeDAO.insert(newEmployee);
//
//
//
//
//        for ( Employee employee : employees ) {
//            System.out.println(employee.getId() + " | " + employee.getFirstName() + " " + employee.getLastName() + " | "
//                    + employee.getEmail() + " | " + employee.getJobTitle());
//
//        }


//                List<Employee> employees = employeeDAO.findByFirstName("First NAME!*!*");
//            System.out.println(employees);


        Employee employee = employeeDAO.findById(1056);

        System.out.println(employee);

        employee = employeeDAO.findById(1);

        System.out.println(employee);

//        List<Customers> customers = customersDAO.findByCustomerName("Mini Wheels Co.");
//
//        System.out.println(customers);
////
//        customers = customersDAO.findByContactFirstName("Janey");
//
//        System.out.println(customers);
//
//        Customers customers1 = customersDAO.findById(520);
//        System.out.println(customers1);


//
//        for ( Customers customer : customers ) {
//                 System.out.println(customer);
//
//        }
        Customers customers = customersDAO.findById(520);
        System.out.println(customers);


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter a first name");
//        String firstName = scanner.nextLine();
//
//        System.out.println(customers);
//
//
//        System.out.println("");




    }
}