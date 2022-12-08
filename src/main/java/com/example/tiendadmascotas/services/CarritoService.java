package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.CarritoProducto;
import com.example.tiendadmascotas.model.Producto;

import java.util.List;

public interface CarritoService {

    Carrito crearCarrito(Carrito carrito);

    CarritoProducto addCarritoProducto(Carrito carrito, Producto producto);

    void eliminarCarrito(Long carritoId);

    List<Producto> verProductosDeCarrito(Long carritoId);

    Carrito verUsuarioCarrito(Long Id);
}
