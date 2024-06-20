package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customers;
import org.example.database.entity.Employee;
import org.example.database.entity.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductsDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public Products findById(Integer id) {

        Session session = factory.openSession();

        String hql = "SELECT p FROM Products p where p.id = :id";

        TypedQuery<Products> query = session.createQuery(hql, Products.class);

        query.setParameter("id", id);

        try {
            Products result = query.getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        } finally {
            session.close();
        }


    }

    public List<Products> findByProductName(String productName) {

        Session session = factory.openSession();


        String hql = "SELECT p FROM Products p where p.productName = :productName";

        TypedQuery<Products> query = session.createQuery(hql, Products.class);


        query.setParameter("productName", productName);

        List<Products> result = query.getResultList();

        session.close();

        return result;

    }

    public List<Products> findLikeName(String productName) {

        Session session = factory.openSession();


        String hql = "SELECT p FROM Products p where p.productName like CONCAT('%', :productName, '%') ";

        TypedQuery<Products> query = session.createQuery(hql, Products.class);


        query.setParameter("productName", productName);

        List<Products> result = query.getResultList();

        session.close();

        return result;

    }

    public void update(Products product) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(product);
        session.getTransaction().commit();
        session.close();
    }

}