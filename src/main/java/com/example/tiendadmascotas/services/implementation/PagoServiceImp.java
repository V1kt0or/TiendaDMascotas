package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Pago;
import com.example.tiendadmascotas.repository.PagoRepository;
import com.example.tiendadmascotas.repository.PedidoRepository;
import com.example.tiendadmascotas.services.PagoService;
import com.example.tiendadmascotas.services.PedidoService;

public class PagoServiceImp implements PagoService {
    @Autowired
    public PagoRepository pagoRepository;

    @java.lang.Override
    public Pago guardarPedido(Pago pago) {
        return pagoRepository.save(pago);
    }

    @java.lang.Override
    public Pago obtenerPedido(Long idP) {
        return pagoRepository.findByID(idP);
    }

    @java.lang.Override
    public void eliminarPedido(Long Id) {

    }

    @java.lang.Override
    public void actualizarPedido(Long Id) {

    }
}
