package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.repository.ProductoRepository;
import com.example.tiendadmascotas.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto verProducto(Long productoId) {
        return productoRepository.findById(productoId).get();
    }

    @Override
    public Producto editarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long productoId) {
        Producto producto = new Producto();
        producto.setId(productoId);
        productoRepository.delete(producto);
    }
}
