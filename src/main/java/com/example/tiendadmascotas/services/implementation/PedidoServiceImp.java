package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Pedido;
import com.example.tiendadmascotas.repository.PedidoRepository;
import com.example.tiendadmascotas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImp implements PedidoService {
    @Autowired
    public PedidoRepository pedidoRepository;

    @java.lang.Override
    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @java.lang.Override
    public Pedido obtenerPedido(Long idP) {
        return pedidoRepository.findByID(idP);
    }

    @java.lang.Override
    public void eliminarPedido(Long usuarioId) {

    }

    @java.lang.Override
    public void actualizarPedido(Long IdP, String estado) {
        Pedido pedidoU= obtenerPedido(IdP);
        pedidoU.setEstado("true");
    }
}
