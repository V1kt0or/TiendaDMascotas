package com.example.tiendadmascotas.repository;

import com.example.tiendadmascotas.model.Imagen;
import com.example.tiendadmascotas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {

    public List<Imagen> findByProducto(Producto producto);
}
