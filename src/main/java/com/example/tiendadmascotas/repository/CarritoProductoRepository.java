package com.example.tiendadmascotas.repository;

import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.CarritoProducto;
import com.example.tiendadmascotas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoProductoRepository extends JpaRepository<CarritoProducto,Long> {

    public CarritoProducto findTopByProductoAndCarrito(Producto producto, Carrito carrito);

    public List<CarritoProducto> findAllByCarrito(Carrito carrito);
}
