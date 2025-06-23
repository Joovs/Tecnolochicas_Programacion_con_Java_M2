package com.bedu.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bedu.inventario.entity.Marca;
import com.bedu.inventario.entity.Producto;
import com.bedu.inventario.repository.MarcaRepository;
import com.bedu.inventario.repository.ProductoRepository;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@SuppressWarnings("unused")
	@Bean
    public CommandLineRunner demo(ProductoRepository productoRepository, MarcaRepository marcaRepository) {
        return (args) -> {
			//guardar al menos dos marcas
			Marca apple = new Marca("Apple");
			Marca samsung = new Marca("Samsung");
			marcaRepository.save(apple);
			marcaRepository.save(samsung);

            // Guardar al menos dos productos por cada marca
            productoRepository.save(new Producto("iPhone 11", "Parecido al 12", 15000.00, apple));
            productoRepository.save(new Producto("iPad Pro", "Más grande que la anterior", 14000.00, apple));
            productoRepository.save(new Producto("Galaxy S23", "Buena cámara", 7000.00, samsung));
            productoRepository.save(new Producto("Smart TV", "12 pulgadas", 13000.00, samsung));
            

			//salida en consola
			System.out.println("-- Productos por marca: --");
			marcaRepository.findAll().forEach(marca -> {
				System.out.println("* " + marca.getNombre() + ":");
				productoRepository.findAll().stream()
					.filter(p -> p.getMarca().getId().equals(marca.getId()))
					.forEach(p -> System.out.println("   - " + p.getNombre()));
			});
        };

		//https://stackoverflow.com/questions/60651244/process-command-c-program-files-java-jdk-bin-java-exe-finished-with-non-zer
    }

}
