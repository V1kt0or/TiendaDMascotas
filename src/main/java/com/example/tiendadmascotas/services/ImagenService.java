package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Imagen;
import org.springframework.web.multipart.MultipartFile;

public interface ImagenService {


    Imagen agregarImagen(MultipartFile file) throws Exception;

    Imagen verImagen(Long imagenId);

    Imagen obtenerImagen(Long imagenId) throws  Exception;

    void eliminarImagen(Long imagenId);
}
