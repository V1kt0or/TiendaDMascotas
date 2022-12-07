package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.model.Usuario;

import java.util.List;

public interface ProductoService {

    public Producto guardarProducto(Producto producto);

    public  Producto verProducto(Long productoId);

    public List<Producto> verTodosProductos();


    public Producto editarProducto(Producto producto);

    public List<Producto> verProducstosDeCategoria(Long categoriaId);
    public void eliminarProducto(Long productoId);
}
