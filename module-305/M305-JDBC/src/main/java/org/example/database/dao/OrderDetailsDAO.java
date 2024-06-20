package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.OrderDetails;
import org.example.database.entity.Orders;
import org.example.database.entity.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Order;

public class OrderDetailsDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public OrderDetails findByOrderIdAndProductId(Integer orderId, Integer productId) {

        Session session = factory.openSession();


        String hql = "SELECT od FROM OrderDetails od where od.products.id = :productId and od.orders.id = :orderId";

        TypedQuery<OrderDetails> query = session.createQuery(hql,OrderDetails.class);


        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);



        try {
            OrderDetails result = query.getSingleResult();
            return result;
        } catch ( NoResultException e ) {
            return null;
        } finally {
            session.close();

        }
    }


    public void insert(OrderDetails orderDetails) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(orderDetails);
        session.getTransaction().commit();
        session.close();
    }

    public void update(OrderDetails orderDetails) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.update(orderDetails);
        session.getTransaction().commit();
        session.close();
    }
}