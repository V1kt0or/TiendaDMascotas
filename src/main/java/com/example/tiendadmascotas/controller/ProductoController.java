package com.example.tiendadmascotas.controller;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    public ProductoService productoService;



    @PostMapping("/")
    public Producto guardarProducto(@RequestBody Producto producto){



        return productoService.guardarProducto(producto);
        //-------------------------------
        //GENERAR UNA EXCEPCIÓN PARA VER CUANDO AÑADAN UNA CATEGORIA QUE NO EXISTE
        //O QUE YA EXISTA LA RELACION CATEGORIAPRODUCTO
        //
    }

    @GetMapping("/{productoId}")
    public Producto obtenerProducto(@PathVariable("productoId") Long productoId){
        return productoService.verProducto(productoId);
    }

    @PutMapping("/{productoId}")
    public Producto modificarProducto(@RequestBody Producto producto){
        return productoService.editarProducto(producto);
    }

    @GetMapping("/")
    public List<Producto> obtenerTodosProductos(){
        return productoService.verTodosProductos();
    }


    @GetMapping("/categoria/{categoryId}")
    public List<Producto> obtenerTodosProductos(@PathVariable("categoryId") Long categoryId){
        return productoService.verProducstosDeCategoria(categoryId);
    }

    @DeleteMapping("/{productoId}")
    public void eliminarProducto(@PathVariable("productoId") Long productoId){
        productoService.eliminarProducto(productoId);
    }
}
