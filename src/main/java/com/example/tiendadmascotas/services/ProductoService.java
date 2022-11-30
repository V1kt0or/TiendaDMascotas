package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Producto;

public interface ProductoService {

    public Producto guardarProducto(Producto producto);

    public  Producto verProducto(Long productoId);

    public Producto editarProducto(Producto producto);

    public void eliminarProducto(Long productoId);
}
