package com.example.tiendadmascotas.controller;


import com.example.tiendadmascotas.model.Imagen;
import com.example.tiendadmascotas.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/imagenes")
@CrossOrigin("*")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @PostMapping("/")
    public ResponseEntity<?> guardarArchivo(@RequestParam("file") MultipartFile file) throws Exception {
        Imagen imagen = null;
        imagen  = imagenService.agregarImagen(file);
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
