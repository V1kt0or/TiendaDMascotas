package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.CategoriaProducto;
import com.example.tiendadmascotas.model.Producto;

import java.util.List;

public interface CategoriaProductoService {

    public void añadirCategoriaProducto(Categoria categoria, Producto producto);

    public List<CategoriaProducto> verCategoriaProductoPorProducto(Long productoID);

    public void eliminarCategoriaProucto(Long CategoriaProductoId);
}
