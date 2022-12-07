package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Pedido;

public interface PedidoService {

    public Pedido guardarPedido(Pedido pedido);

    public Pedido obtenerPedido(Long idP);

    public void eliminarPedido(Long usuarioId);

    public void actualizarPedido(Long usuarioId);
}
