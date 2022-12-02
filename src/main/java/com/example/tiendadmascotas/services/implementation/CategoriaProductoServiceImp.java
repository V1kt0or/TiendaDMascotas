package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.CategoriaProducto;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.repository.CategoriaProductoRepository;
import com.example.tiendadmascotas.services.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoServiceImp implements CategoriaProductoService {

    @Autowired
    public CategoriaProductoRepository categoriaProductoRepository;

    @Override
    public void añadirCategoriaProducto(Categoria categoria, Producto producto) {
        CategoriaProducto categoriaProducto = new CategoriaProducto();
        categoriaProducto.setCategoria(categoria);
        categoriaProducto.setProducto(producto);

        categoriaProductoRepository.save(categoriaProducto);
    }

    @Override
    public List<CategoriaProducto> verCategoriaProductoPorProducto(Long productoID) {
        Producto producto = new Producto();
        producto.setId(productoID);
        return categoriaProductoRepository.findByProducto(producto);
    }

    @Override
    public void eliminarCategoriaProucto(Long CategoriaProductoId) {
        CategoriaProducto categoriaProducto = new CategoriaProducto();
        categoriaProducto.setId(CategoriaProductoId);
        categoriaProductoRepository.delete(categoriaProducto);
    }
}
