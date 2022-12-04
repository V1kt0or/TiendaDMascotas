package com.example.tiendadmascotas.controller;


import com.example.tiendadmascotas.model.Imagen;
import com.example.tiendadmascotas.services.ImagenService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/imagenes")
@CrossOrigin("*")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;



    @PostMapping("/")
    public ResponseEntity<?> guardarArchivo(@RequestParam("file") MultipartFile file, String info) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(info);
        Imagen imagen = null;
        imagen  = imagenService.agregarImagen(file,Long.parseLong(info));
        String URLDescarga = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/descarga/")
                .path(imagen.getId().toString())
                .toUriString();
        System.out.println(URLDescarga);

        return ResponseEntity.ok(imagen);
    }

    @GetMapping("/{imagenId}")
    public Imagen listarImagenPorId(@PathVariable("imagenId") Long imagenId){
        return imagenService.verImagen(imagenId);
    }

    @GetMapping("/producto/{productoId}")
    public List<Imagen> listarImagenPorProducto(@PathVariable("productoId") Long productoId){
        return imagenService.obtenerImagenesDeProducto(productoId);
    }

    @GetMapping("/descarga/{imagenId}")
    public ResponseEntity<?> DescargarImagen(@PathVariable  Long imagenId) throws  Exception {
        Imagen imagen = imagenService.obtenerImagen(imagenId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imagen.getTipoImagen()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"imagen; nombreImagen=\""+ imagen.getNombreImagen()+"\"")
                .body(new ByteArrayResource(imagen.getDataImagen()));
    }


    @DeleteMapping("/{imagenId}")
    public void eñiminarImagen(@PathVariable("imagenId") Long imagenId){
        imagenService.eliminarImagen(imagenId);
    }
}
