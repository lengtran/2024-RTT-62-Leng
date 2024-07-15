package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    Product findById(Integer id);

    // this is a jpa query, similar to hibernate module
    @Query("select p from Product p where p.productName like concat('%', :name, '%')")
    List<Product> findByName(String name);
}
