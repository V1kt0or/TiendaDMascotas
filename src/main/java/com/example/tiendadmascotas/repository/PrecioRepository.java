package com.example.tiendadmascotas.repository;

import com.example.tiendadmascotas.model.Precio;
import com.example.tiendadmascotas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrecioRepository extends JpaRepository<Precio,Long> {

    public Precio findByProducto (Producto producto);
    
    public List<Precio> findAllByOrderByMonto();
}
