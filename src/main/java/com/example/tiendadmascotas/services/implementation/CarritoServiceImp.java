package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.*;
import com.example.tiendadmascotas.repository.CarritoProductoRepository;
import com.example.tiendadmascotas.repository.CarritoRepository;

import com.example.tiendadmascotas.repository.PrecioRepository;
import com.example.tiendadmascotas.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Service
public class CarritoServiceImp implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;
    @Autowired
    private CarritoProductoRepository carritoProductoRepository;

    @Autowired
    PrecioRepository precioRepository;


    @Override
    public Carrito crearCarrito(Carrito carrito) {

        return carritoRepository.save(carrito);
    }

    @Override
    public CarritoProducto addCarritoProducto(Carrito carrito,Producto producto) {
        CarritoProducto carritoProducto = new CarritoProducto();
        carritoProducto.setCarrito(carrito);
        carritoProducto.setProducto(producto);
        carritoProductoRepository.save(carritoProducto); //Guardar el registro
        return carritoProductoRepository.save(carritoProducto);
    }

    @Override
    public void eliminarProductoCarrito(Long carritoId, Long productoId) {
        Carrito carrito = new Carrito();
        Producto producto = new Producto();
        carrito.setId(carritoId);
        producto.setId(productoId);

        CarritoProducto carritoProducto = carritoProductoRepository.findTopByProductoAndCarrito(producto,carrito);
        System.out.println(carritoProducto.getCarrito().getId());
        CarritoProducto carritoProducto1 = new CarritoProducto();
        carritoProducto1.setId(carritoProducto.getId());
        carritoProductoRepository.delete(carritoProducto1);
    }


    @Override
    public void eliminarCarrito(Long carritoId) {
        Carrito carrito=new Carrito();
        carrito.setId(carritoId);
        carritoRepository.delete(carrito);
    }

    @Override
    public List<Precio> verProductosDeCarrito(Long carritoId) {
        Carrito carrito = new Carrito();
        carrito.setId(carritoId);
        List<CarritoProducto> productosPorCarrito = carritoProductoRepository.findAllByCarrito(carrito);
        List<Precio> precios = new ArrayList<>();
        for (CarritoProducto carritoProducto : productosPorCarrito) {
            Precio precio = precioRepository.findByProducto(carritoProducto.getProducto());
            precios.add(precio);

        }
        return precios;
    }

    @Override
    public Carrito verUsuarioCarrito(Long Id) {
        Usuario usuario=new Usuario();
        usuario.setId(Id);
        return carritoRepository.findByUsuario(usuario);

    }

}
