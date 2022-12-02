package com.example.tiendadmascotas.controller;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.services.CategoriaProductoService;
import com.example.tiendadmascotas.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductoController {

    static class ProductoyCategoria {
        public Producto productoR;
        public List<Categoria> categoriaR;
    }
    @Autowired
    public ProductoService productoService;

    @Autowired
    public CategoriaProductoService categoriaProductoService;

    @PostMapping("/")
    public Producto guardarProducto(@RequestBody ProductoyCategoria productoyCategoria){
        productoService.guardarProducto(productoyCategoria.productoR);
        for (Categoria categoria:productoyCategoria.categoriaR){
            categoriaProductoService.añadirCategoriaProducto(categoria,productoyCategoria.productoR);
        }

        return productoService.guardarProducto(productoyCategoria.productoR);
        //-------------------------------
        //GENERAR UNA EXCEPCIÓN PARA VER CUANDO AÑADAN UNA CATEGORIA QUE NO EXISTE
        //O QUE YA EXISTA LA RELACION CATEGORIAPRODUCTO
        //
    }

    @GetMapping("/{productoId}")
    public Producto obtenerCategoria(@PathVariable("productoId") Long productoId){
        categoriaProductoService.f
        return productoService.verProducto(productoId);
    }


    @GetMapping("/")
    public List<Producto> obtenerTodosProcutos(){
        return productoService.verTodosProductos();
    }

    @DeleteMapping("/{categoryId}")
    public void eliminarProducto(@PathVariable("productoId") Long productoId){
        productoService.eliminarProducto(productoId);
    }
}
