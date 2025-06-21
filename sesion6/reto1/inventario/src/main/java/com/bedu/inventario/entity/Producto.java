package com.bedu.inventario.entity;


import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//import jakarta.validation.constraints.Min;

@Entity
public class Producto {
    //atributos o campos de tabla
    @Id // Campo que funcionará como clave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se generará automáticamente (autoincremental)
    private Long id;

    // Campos que serán columnas en la tabla 'producto'
    @NonNull
    private String nombre;
    @NonNull
    private String descripcion;
    //@Min(1)
    private double precio;

    protected Producto() {} // Constructor por defecto requerido por JPA

    // Constructor público para crear objetos de tipo Producto con los campos necesarios
    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
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


    // Método que permite imprimir el objeto de forma legible (útil para logs o consola)
    @Override
    public String toString() {
        return "Proucto: [id="+id+", nombre='"+nombre+"', precio=$"+precio+"]";
    }

    /*

    To use @NotBlank for validation in a Spring Boot application with Gradle, the spring-boot-starter-validation dependency must be added to the build.gradle file.
    1. Add the Dependency:
    Include the following in your build.gradle file within the dependencies block:
    Código

    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-validation'
    }

    2. Import the Annotation:
    In your Java or Kotlin code where you want to use @NotBlank, ensure the correct import statement is present: For Spring Boot versions before 3.0.
    Java

        import javax.validation.constraints.NotBlank;

        For Spring Boot 3.0 and later (which uses Jakarta EE):

    Java

        import jakarta.validation.constraints.NotBlank;

    3. Apply the Annotation:
    Apply the @NotBlank annotation to fields of type CharSequence (e.g., String) in your DTOs or entities that require validation to ensure they are not null and contain at least one non-whitespace character.
    Java

    public class MyDto {
        @NotBlank
        private String name;

        // ... other fields and methods
    }

    */
}
