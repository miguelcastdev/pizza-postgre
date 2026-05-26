package com.example.base_postpizza.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizzas")
public class Pizzeria{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = false, length = 100)
    private String ingrediente;

    @Column(nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal precio;

    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return ingrediente;
    }
    public void setNombre(String nombre) {
        this.ingrediente = nombre;
    }

    public java.math.BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(java.math.BigDecimal precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return id + " :: " + ingrediente + " :: " + precio;
    }
}