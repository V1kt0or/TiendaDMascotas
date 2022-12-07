package com.example.tiendadmascotas.repository;

import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito,Long> {

    public Carrito findByUsuario(Usuario usuario);
}
