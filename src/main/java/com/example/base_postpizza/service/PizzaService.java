package com.example.base_postpizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.base_postpizza.model.Pizzeria;
import com.example.base_postpizza.repository.PizzeriaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PizzaService{   

    @Autowired
	private PizzeriaRepository repo;

	public List<Pizzeria> getAll() {
		return repo.findAll();
	}

	public void save(Pizzeria pizza) {
		repo.save(pizza);
	}

	public Pizzeria getById(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}