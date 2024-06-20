package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public void insert( Employee employee) {

        //first two lines of code begin the hibernate session
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(employee);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();


    }


    public List<Employee> findByFirstName(String firstName) {
        // this where the code goes to execute the query
        // these 2 lines of code prepare the hibernate session for use
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        // SQL - "select * from employees e where e.firstname = ?"
        String hql = "SELECT e FROM Employee e where e.firstName = :firstName";

        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Employee> query = session.createQuery(hql,Employee.class);

        // this is similar to the prepared statement, we are going to set the value in the query :firstname
        // to the value passed into the function
        query.setParameter("firstName", firstName);

        // when we know we are getting 0 or more records we use getResultList
        List<Employee> result = query.getResultList();

        // finally we close the hibernate session so it can release the resources its holding
        // specifically the connection pool and close the transaction
        session.close();

        return result;
    }

    public List<Employee> findByLastName(String lastName) {
        // this where the code goes to execute the query
        // these 2 lines of code prepare the hibernate session for use
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        // SQL - "select * from employees e where e.lastname = ?"
        String hql = "SELECT e FROM Employee e where e.lastName = :lastName";

        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Employee> query = session.createQuery(hql,Employee.class);

        // this is similar to the prepared statement, we are going to set the value in the query :lastname
        // to the value passed into the function
        query.setParameter("lastName", lastName);

        // when we know we are getting 0 or more records we use getResultList
        List<Employee> result = query.getResultList();

        // finally we close the hibernate session so it can release the resources its holding
        // specifically the connection pool and close the transaction
        session.close();

        return result;
    }

    public Employee findById(Integer id) {
        // this where the code goes to execute the query
        // these 2 lines of code prepare the hibernate session for use
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        // SQL - "select * from employees e where e.firstname = ?"
        String hql = "SELECT e FROM Employee e where e.id = :id";

        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Employee> query = session.createQuery(hql,Employee.class);

        // this is similar to the prepared statement, we are going to set the value in the query :firstname
        // to the value passed into the function
        query.setParameter("id", id);

        // we know we are querying a PK so the result will either be found or not found
        // unforunately, in 2010 this implementation throws an exception if the record isn't found
        // this does not exist in 2024
        try {
            Employee result = query.getSingleResult();
            return result;
        } catch ( NoResultException e ) {
            return null;
        } finally {
            session.close();

        }

        // finally we close the hibernate session so it can release the resources its holding
        // specifically the connection pool and close the transaction

    }

    public void update(Employee employee) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(employee);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Employee employee) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }

}