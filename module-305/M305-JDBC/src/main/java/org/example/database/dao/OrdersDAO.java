package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customers;
import org.example.database.entity.Employee;
import org.example.database.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OrdersDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public Orders findById(Integer id) {

        Session session = factory.openSession();


        String hql = "SELECT o FROM Orders o where o.id = :id";

        TypedQuery<Orders> query = session.createQuery(hql,Orders.class);


        query.setParameter("id", id);



        try {
            Orders result = query.getSingleResult();
            return result;
        } catch ( NoResultException e ) {
            return null;
        } finally {
            session.close();

        }
    }

    public List<Orders> findByCustomerId(Integer customerId) {

        Session session = factory.openSession();


        String hql = "SELECT o FROM Orders o where o.customerID = :customerId";

        TypedQuery<Orders> query = session.createQuery(hql,Orders.class);


        query.setParameter("customerId", customerId);

        List<Orders> result = query.getResultList();


        session.close();

        return result;
    }

}