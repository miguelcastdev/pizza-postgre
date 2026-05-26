package com.example.base_postpizza.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.base_postpizza.model.Pizzeria;
import com.example.base_postpizza.service.PizzaService;

@RestController
@RequestMapping("pizzas")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PizzaController {

    @Autowired
    private PizzaService service;

    @GetMapping
    public List<Pizzeria> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Pizzeria> getById(@PathVariable Integer id) {
        Pizzeria pizza = service.getById(id);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    @PostMapping
    public void registrar(@RequestBody Pizzeria pizza) {
        service.save(pizza);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Pizzeria pizzeria, @PathVariable Integer id) {
        try {
            Pizzeria auxPizzeria = service.getById(id);
            pizzeria.setId(auxPizzeria.getId());
            service.save(pizzeria);
            return new ResponseEntity<>("Updated record", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("The record with the id provided is not found in the database", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
