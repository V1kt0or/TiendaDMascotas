package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Pago;
import com.example.tiendadmascotas.repository.PagoRepository;
import com.example.tiendadmascotas.repository.PedidoRepository;
import com.example.tiendadmascotas.services.PagoService;
import com.example.tiendadmascotas.services.PedidoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PagoServiceImp implements PagoService {
    @Autowired
    public PagoRepository pagoRepository;

    @java.lang.Override
    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @java.lang.Override
    public Pago obtenerPago(Long idP) {
        return pagoRepository.findById(idP).get();
    }

    @java.lang.Override
    public void eliminarPago(Long Id) {

    }

    @java.lang.Override
    public void actualizarPago(Long Id) {

    }
}
