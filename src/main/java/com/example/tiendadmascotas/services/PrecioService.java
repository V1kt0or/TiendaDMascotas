package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Precio;
import com.example.tiendadmascotas.model.Producto;

import java.util.List;

public interface PrecioService {

    public Precio GuardarPrecio(Precio precio);

    public Precio VerPrecio(Producto producto);

    public Precio EditarPrecio(Precio precio);

    public List<Precio> VerTodosPrecios();

    public void EliminarPrecio(Precio precio);

}
