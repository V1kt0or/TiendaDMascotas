package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Pago;
import com.example.tiendadmascotas.repository.PagoRepository;
import com.example.tiendadmascotas.services.PagoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PagoServiceImp implements PagoService {
    @Autowired
    public PagoRepository pagoRepository;

    @Override
    public List<Pago> obtenerPagos() {
        return pagoRepository.findAll();
    }

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
        pagoRepository.deleteById(Id);
    }
}
