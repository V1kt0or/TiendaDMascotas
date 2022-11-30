package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.repository.CategoríaRepository;
import com.example.tiendadmascotas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class CategoriaSeriveImp implements CategoriaService {

    @Autowired
    private CategoríaRepository categoríaRepository;

    @Override
    public Categoria añadirCategoria(Categoria categoria) {
        return categoríaRepository.save(categoria);
    }

    @Override
    public Categoria verCategoria(Long categoriaId) {
        return categoríaRepository.findById(categoriaId).get();
    }

    @Override
    public List<Categoria> verTodasCategorias() {
        return categoríaRepository.findAll();
    }

    @Override
    public Categoria editarCategoria(Categoria categoria) {
        return categoríaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);
        categoríaRepository.delete(categoria);
    }
}
