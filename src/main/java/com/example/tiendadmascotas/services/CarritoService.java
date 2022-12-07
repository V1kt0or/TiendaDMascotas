package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.Producto;

import java.util.Optional;

public interface CarritoService {


    public Carrito crearCarrito(Carrito carrito);


    public Producto addCarritoProducto(Carrito carrito,Producto producto);

    public void eliminarCarrito(Long carritoId);
}
