package com.example.tiendadmascotas.controller;


import com.example.tiendadmascotas.model.Pago;
import com.example.tiendadmascotas.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
@CrossOrigin("*")
public class PagoController {
    @Autowired
    public PagoService pagoService;

    @GetMapping("/")
    public List<Pago> obtenerPagos(){
        return pagoService.obtenerPagos();
    }


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
