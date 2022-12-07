package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Carrito;
import com.example.tiendadmascotas.model.CarritoProducto;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.model.Usuario;
import com.example.tiendadmascotas.repository.CarritoProductoRepository;
import com.example.tiendadmascotas.repository.CarritoRepository;

import com.example.tiendadmascotas.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarritoServiceImp implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;
    @Autowired
    private CarritoProductoRepository carritoProductoRepository;


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

    @Override
    public List<Producto> verProducstosDeCarrito(Long carritoId) {
        List<CarritoProducto> productosPorCarrito= carritoProductoRepository.findAll();
        List<Producto> productos=new ArrayList<>();
        for (int i=0; i<productosPorCarrito.size(); i++) {
            if(Objects.equals(productosPorCarrito.get(i).getCarrito().getId(), carritoId)){
                productos.add(productosPorCarrito.get(i).getProducto());
            }
        }
        return productos;
    }

    @Override
    public Carrito verUsuarioCarrito(Long Id) {
        Usuario usuario=new Usuario();
        usuario.setId(Id);
        return carritoRepository.findByUsuario(usuario);

    }

}
