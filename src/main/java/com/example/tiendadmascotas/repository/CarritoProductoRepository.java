package com.example.tiendadmascotas.repository;

import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.CarritoProducto;
import com.example.tiendadmascotas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarritoProductoRepository extends JpaRepository<CarritoProducto,Long> {

    CarritoProducto findTopByProductoAndCarrito(Producto producto, Carrito carrito);

    List<CarritoProducto> findAllByCarrito(Carrito carrito);

    void deleteAllByCarrito(Carrito carrito); //Eliminar productos locales del carrito una vez pagado
}