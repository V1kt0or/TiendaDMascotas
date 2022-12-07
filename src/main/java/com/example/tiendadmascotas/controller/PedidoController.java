package com.example.tiendadmascotas.controller;


import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Pedido;
import com.example.tiendadmascotas.model.Precio;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    public PedidoService pedidoService;

    @PostMapping("/")
    public Pedido guardarPago(@RequestBody Pedido pedido){
        return pedidoService.guardarPedido(pedido);
    }

    @GetMapping("/{pedidoId}")
    public Pedido obtenerPago(@PathVariable("pedidoId") Long pedidoId){
        return pedidoService.obtenerPedido(pedidoId);
    }

    @DeleteMapping("/{pedidoId}")
    public void eliminarPago(@PathVariable("pedidoId") Long pedidoId){
        pedidoService.eliminarPedido(pedidoId);
    }

    @PutMapping("/{pedidoId}")
    public void modificarPedido(@PathVariable("pedidoId") Long pedidoId){

        pedidoService.actualizarPedido(pedidoId);
    }
}
