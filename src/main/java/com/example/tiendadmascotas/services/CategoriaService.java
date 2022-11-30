package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface CategoriaService {

    public Categoria añadirCategoria(Categoria categoria);

    public Categoria verCategoria(Long categoriaId);

    public List<Categoria> verTodasCategorias();

    public Categoria editarCategoria(Categoria categoria);

    public void eliminarCategoria(Long categoriaId);
}
