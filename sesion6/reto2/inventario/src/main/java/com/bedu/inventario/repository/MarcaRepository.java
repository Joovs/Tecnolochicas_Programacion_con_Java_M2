package com.bedu.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bedu.inventario.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
    
}
