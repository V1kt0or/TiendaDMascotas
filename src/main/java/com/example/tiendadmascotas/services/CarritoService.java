package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.CarritoProducto;
import com.example.tiendadmascotas.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface CarritoService {

    public Carrito crearCarrito(Carrito carrito);


    public Producto addCarritoProducto(Carrito carrito, Producto producto);

    public void eliminarCarrito(Long carritoId);

    public List<Producto> verProducstosDeCarrito(Long carritoId);
}
