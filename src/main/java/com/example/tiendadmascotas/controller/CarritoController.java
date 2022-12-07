package com.example.tiendadmascotas.controller;


import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.Precio;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/añadir")
    public Producto addCarrito(@RequestBody CarritoProducto carritoProducto){
        Producto producto;
        Carrito carrito;
        carritoService.addCarritoProducto(carritoProducto.carritoR,carritoProducto.productoR);
        return carritoProducto.productoR;
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
