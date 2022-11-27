package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Pago;
import com.example.tiendadmascotas.model.Pedido;

public interface PagoService {
    public Pago guardarPedido(Pago pago);

    public Pago obtenerPedido(Long idP);

    public void eliminarPedido(Long Id);

    public void actualizarPedido(Long Id);

}
