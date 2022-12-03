package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Precio;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.model.Usuario;
import com.example.tiendadmascotas.repository.PrecioRepository;
import com.example.tiendadmascotas.repository.ProductoRepository;
import com.example.tiendadmascotas.services.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecioServiceImp implements PrecioService {

    @Autowired
    private PrecioRepository precioRepository;



    @Override
    public Precio GuardarPrecio(Precio precio) {

        return precioRepository.save(precio);
    }

    @Override
    public Precio VerPrecio(Producto producto) {
        return precioRepository.findByProducto(producto);
    }

    @Override
    public Precio EditarPrecio(Precio precio) {

        return precioRepository.save(precio);
    }

    @Override
    public List<Precio> VerTodosPrecios() {
        return precioRepository.findAll();
    }

    @Override
    public void EliminarPrecio(Precio precio) {
        precioRepository.delete(precio);
    }


}


