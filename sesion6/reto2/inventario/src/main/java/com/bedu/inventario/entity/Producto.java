package com.bedu.inventario.entity;


import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//import jakarta.validation.constraints.Min;

@Entity
public class Producto {
    //atributos o Campos que serán columnas en la tabla 'producto'
    @Id // Campo que funcionará como clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se generará automáticamente (autoincremental)
    private Long id;

    
    @NonNull
    private String nombre;
    @NonNull
    private String descripcion;
    //@Min(1)
    private double precio;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;


    protected Producto() {} // Constructor por defecto requerido por JPA

    // Constructor público para crear objetos de tipo Producto con los campos necesarios
    public Producto(String nombre, String descripcion, double precio, Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    // Método que permite imprimir el objeto de forma legible (útil para logs o consola)
    @Override
    public String toString() {
        if (marca != null){
            return "Proucto: [id="+id+", nombre='"+nombre+"', precio=$"+precio+", categoria="+marca.getNombre()+"]";
        } else {
            return "Proucto: [id="+id+", nombre='"+nombre+"', precio=$"+precio+", sin categoría]";
        }
    }

 
}
