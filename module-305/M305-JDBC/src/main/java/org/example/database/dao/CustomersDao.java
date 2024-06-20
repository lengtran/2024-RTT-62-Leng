package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customers;
import org.example.database.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomersDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public List<Customers> findByCustomerName(String customerName) {

        Session session = factory.openSession();


        String hql = "SELECT c FROM Customers c where c.customerName = :customerName";

        TypedQuery<Customers> query = session.createQuery(hql, Customers.class);


        query.setParameter("customerName", customerName);

        List<Customers> result = query.getResultList();

        session.close();

        return result;

    }

    public List<Customers> findByContactFirstName(String contactFirstName) {

        Session session = factory.openSession();


        String hql = "SELECT c FROM Customers c where c.contactFirstName = :contactFirstName";

        TypedQuery<Customers> query = session.createQuery(hql, Customers.class);


        query.setParameter("contactFirstName", contactFirstName);

        List<Customers> result = query.getResultList();

        session.close();

        return result;

    }

    public Customers findById(Integer id) {

        Session session = factory.openSession();


        String hql = "SELECT c FROM Customers c where c.id = :id";

        TypedQuery<Customers> query = session.createQuery(hql, Customers.class);


        query.setParameter("id", id);


        try {
            Customers result = query.getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Customers> findByIdList(Integer id) {

        Session session = factory.openSession();


        String hql = "SELECT c FROM Customers c where c.id = :id";

        TypedQuery<Customers> query = session.createQuery(hql, Customers.class);


        query.setParameter("id", id);


        List<Customers> result = query.getResultList();



        session.close();
        return result;
    }

    public void insert(Customers customer) {

        //first two lines of code begin the hibernate session
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(customer);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();


    }

    public void update(Customers customers) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(customers);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Customers customers) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(customers);
        session.getTransaction().commit();
        session.close();
    }


}