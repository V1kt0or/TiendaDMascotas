package com.example.tiendadmascotas.repository;

import com.example.tiendadmascotas.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecioRepository extends JpaRepository<Precio,Long> {
}
