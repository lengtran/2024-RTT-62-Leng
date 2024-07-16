package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeDAO extends JpaRepository<Office, Long> {

    Office findById(Integer id);

}
