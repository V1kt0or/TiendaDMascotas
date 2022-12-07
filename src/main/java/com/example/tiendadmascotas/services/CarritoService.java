package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.Producto;

import java.util.List;
import java.util.Optional;

public interface CarritoService {


    public Carrito crearCarrito(Carrito carrito);


    public Producto addCarritoProducto(Carrito carrito,Producto producto);

    public void eliminarCarrito(Long carritoId);

    public List<Producto> verProducstosDeCarrito(Long carritoId);
}
