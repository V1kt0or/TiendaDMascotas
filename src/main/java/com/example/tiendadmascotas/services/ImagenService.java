package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Imagen;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface ImagenService {


    Imagen agregarImagen(MultipartFile file, Long idProducto) throws Exception;

    Imagen verImagen(Long imagenId);

    Imagen obtenerImagen(Long imagenId) throws  Exception;

    List<Imagen> obtenerImagenesDeProducto(Long productoId);

    void eliminarImagen(Long imagenId);
}
