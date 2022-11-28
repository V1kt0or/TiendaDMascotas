package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Precio;

public interface PrecioService {

    public Precio GuardarPrecio(Precio precio);

    public Precio VerPrecio(Precio precio);

    public Precio EditarPrecio(Precio precio);

}
