package com.example.tiendadmascotas.controller;


import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Pago;
import com.example.tiendadmascotas.model.Precio;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pago")
@CrossOrigin("*")
public class PagoController {
    @Autowired
    public PagoService pagoService;

    @PostMapping("/")
    public Pago guardarPago(@RequestBody Pago pago){
        return pagoService.guardarPago(pago);
    }

    @GetMapping("/{pagoId}")
    public Pago obtenerPago(@PathVariable("pagoId") Long pagoId){
        return pagoService.obtenerPago(pagoId);
    }

    @DeleteMapping("/{pagoId}")
    public void eliminarPago(@PathVariable("pagoId") Long pagoId){
        pagoService.eliminarPago(pagoId);
    }

}
