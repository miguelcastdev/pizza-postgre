package com.example.base_postpizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.base_postpizza.model.Pizzeria;
;

public interface PizzeriaRepository extends JpaRepository<Pizzeria, Integer>{
    
}