package com.example.tiendadmascotas.repository;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.CategoriaProducto;
import com.example.tiendadmascotas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto,Long> {

    List<CategoriaProducto> findByProducto(Producto producto);

}
