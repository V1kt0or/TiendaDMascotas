package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Pago;

import java.util.List;

public interface PagoService {
    List<Pago> obtenerPagos();

    Pago guardarPago(Pago pago);

    Pago obtenerPago(Long idP);

    void eliminarPago(Long Id);

}
