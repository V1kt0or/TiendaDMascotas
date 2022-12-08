package com.example.tiendadmascotas.controller;


import com.example.tiendadmascotas.model.*;
import com.example.tiendadmascotas.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
@CrossOrigin("*")
public class CarritoController {

    @Autowired
    public  CarritoService carritoService;

    public static class CarritoProducto {
        public Carrito carritoR;
        public Producto productoR;
    }
    @GetMapping("/usuario/{usuarioId}")
    public Carrito obtenerCarritoUsuario(@PathVariable("usuarioId") Long usuarioId){
        return carritoService.verUsuarioCarrito(usuarioId);

    }

    @GetMapping("/{carritoId}/productos")
    public List<Producto> obtenerProductosCarrito(@PathVariable("carritoId") Long carritoId){
        return carritoService.verProductosDeCarrito(carritoId);
    }
    
    @PostMapping("/añadir")
    public com.example.tiendadmascotas.model.CarritoProducto addCarrito(@RequestBody CarritoProducto carritoProducto){
        return carritoService.addCarritoProducto(carritoProducto.carritoR,carritoProducto.productoR);
    }


    @PostMapping("/")
    public Carrito crearCarrito(@RequestBody Carrito carrito){
        return carritoService.crearCarrito(carrito);
    }

    @DeleteMapping("/{carritoId}")
    public void eliminarProducto(@PathVariable("carritoId") Long carritoId){
        carritoService.eliminarCarrito(carritoId);
    }

}
