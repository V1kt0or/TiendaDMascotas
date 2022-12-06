package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Pago;
import com.example.tiendadmascotas.model.Pedido;

public interface PagoService {
    public Pago guardarPago(Pago pago);

    public Pago obtenerPago(Long idP);

    public void eliminarPago(Long Id);

    public void actualizarPago(Long Id);

}
