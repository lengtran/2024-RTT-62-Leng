package org.example;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/classic_models";
        String user = "root";
        String password = "Ltt3538240!";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first name of the employee you want to search for: ");
            String input = scanner.nextLine();

            String selectSQL = "Select * FROM employees where firstname = ? or lastname = ? ";

            // to prevent sql injection
            PreparedStatement stmt = connection.prepareStatement(selectSQL);
            stmt.setString(1, input);
            stmt.setString(2,"Doe");

            ResultSet result =  stmt.executeQuery(selectSQL);

            while(result.next())
            {
                String EmployeeID  = result.getString("id");
                String fname = result.getString("firstName");
                String lname  = result.getString("lastName");
                String email  = result.getString("email");
                System.out.println(EmployeeID + " | " + fname + " | " + lname + " | " + email + " | ");
            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}