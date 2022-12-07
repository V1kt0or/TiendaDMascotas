package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.CarritoProducto;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.repository.CarritoRepository;

import com.example.tiendadmascotas.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CarritoServiceImp implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;



    @Override
    public Carrito crearCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Producto addCarritoProducto(Carrito carrito,Producto producto) {
        CarritoProducto carritoProducto=new CarritoProducto();
        carritoProducto.setId(carrito.getId());
        carritoProducto.setCarrito(carrito);
        carritoProducto.setProducto(producto);
        return producto;
    }

    @Override
    public void eliminarCarrito(Long carritoId) {
        Carrito carrito=new Carrito();
        carrito.setId(carritoId);
        carritoRepository.delete(carrito);
    }
}
