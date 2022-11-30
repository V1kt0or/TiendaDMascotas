package com.example.tiendadmascotas.controller;


import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Usuario;
import com.example.tiendadmascotas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    public CategoriaService categoriaService;

    @PostMapping("/")
    public Categoria guardarCategoria(@RequestBody Categoria categoria){
        return categoriaService.añadirCategoria(categoria);
    }

    @GetMapping("/{categoryId}")
    public Categoria obtenerCategoria(@PathVariable("categoryId") Long categoryId){
        return categoriaService.verCategoria(categoryId);
    }


    @GetMapping("/")
    public List<Categoria> obtenerTodasCategorias(){
        return categoriaService.verTodasCategorias();
    }

    @DeleteMapping("/{categoryId}")
    public void eliminarCategoria(@PathVariable("categoryId") Long categoryId){
        categoriaService.eliminarCategoria(categoryId);
    }

}
