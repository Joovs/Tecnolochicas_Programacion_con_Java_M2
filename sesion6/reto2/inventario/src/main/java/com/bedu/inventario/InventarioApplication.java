package com.bedu.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bedu.inventario.entity.Producto;
import com.bedu.inventario.repository.ProductoRepository;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@SuppressWarnings("unused")
	@Bean
    public CommandLineRunner demo(ProductoRepository repository) {
        return (args) -> {
            // Guardar algunos productos
            repository.save(new Producto("Laptop", "Portátil de 16 pulgadas", 1200.00));
            repository.save(new Producto("Teclado mecánico", "Switch azul", 800.00));
            repository.save(new Producto("Mouse gamer", "Alta precisión", 600.00));
			repository.save(new Producto("Targeta gráfica", "GTRX", 450));

            // Mostrar todos los productos
            System.out.println("📂 Productos disponibles:");
            repository.findAll().forEach(System.out::println);

            // Buscar por nombre parcial
            System.out.println("\n🔍 Productos que contienen 'Lap':");
            repository.findByNombreContaining("Lap").forEach(System.out::println);

			// imprimir productos con precio mayor a 500
			System.out.println("\nProductos mayores a 500.00:");
			repository.findByPrecioGreaterThan(500.00).forEach(System.out::println);

			// imprimir productos con precio entre 400 y 1000
			System.out.println("\nProductos con precio entre 400 y 1000");
			repository.findByPrecioBetween(400.00, 1000.00).forEach(System.out::println);

			// imprimir productos que comiencen con "M" o "m"
			System.out.println("\nProductos que comienzan con 'M' o 'm':");
			repository.findByNombreStartingWithIgnoreCase("M").forEach(System.out::println);
        };
    }

}
