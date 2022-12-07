package com.example.tiendadmascotas.controller;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Precio;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.services.PrecioService;
import com.example.tiendadmascotas.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    public ProductoService productoService;

    @Autowired
    public PrecioService precioService;

    public static class ProductoPrecio {
        public Producto productoR;
        public Precio precioR;
    }

    @PostMapping("/")
    public Precio guardarProducto(@RequestBody ProductoPrecio productoPrecio){

        Producto producto;
        Precio precio;
        producto = productoService.guardarProducto(productoPrecio.productoR);
        precio = productoPrecio.precioR;
        precio.setProducto(producto);

        return precioService.GuardarPrecio(precio);
        //-------------------------------
        //GENERAR UNA EXCEPCIÓN PARA VER CUANDO AÑADAN UNA CATEGORIA QUE NO EXISTE
        //O QUE YA EXISTA LA RELACION CATEGORIAPRODUCTO
        //
        //AÑADIR EXCEPION PARA EL DESCUENTO QUE NO SE EXCEDA
    }

    @GetMapping("/{productoId}")
    public Precio obtenerProducto(@PathVariable("productoId") Long productoId){

        Producto producto = new Producto();
        producto.setId(productoId);
        return precioService.VerPrecio(producto);
    }

    @PutMapping("/{productoId}")
    public Precio modificarProducto(@RequestBody ProductoPrecio productoPrecio){
        Producto producto;
        Precio precio;
        producto = productoService.guardarProducto(productoPrecio.productoR);
        precio = productoPrecio.precioR;
        precio.setProducto(producto);

        return precioService.GuardarPrecio(precio);
    }

    @GetMapping("/")
    public List<Precio> obtenerTodosProductos(){
        return precioService.VerTodosPrecios();
    }

    @GetMapping("/ordenado/")
    public List<Precio> obtenerProductosOrdenados() {
        return precioService.VerPreciosEnOrden();
    }


    @GetMapping("/categoria/{categoryId}")
    public List<Precio> obtenerTodosProductosDeCategoria(@PathVariable("categoryId") Long categoryId){
        List<Precio> precioList = new ArrayList<>();
        List<Producto> productoList = productoService.verProducstosDeCategoria(categoryId);
        for (Producto producto:productoList){
            Precio precio = precioService.VerPrecio(producto);
            precioList.add(precio);
        }
        return precioList;
    }

    @DeleteMapping("/{productoId}")
    public void eliminarProducto(@PathVariable("productoId") Long productoId){
        Producto producto = new Producto();
        producto.setId(productoId);
        Precio precio = precioService.VerPrecio(producto);
        precioService.EliminarPrecio(precio);
        productoService.eliminarProducto(productoId);
    }
}
