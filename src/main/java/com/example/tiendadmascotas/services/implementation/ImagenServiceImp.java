package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Imagen;
import com.example.tiendadmascotas.repository.ImagenRepository;
import com.example.tiendadmascotas.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenServiceImp implements ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    @Override
    public Imagen agregarImagen(MultipartFile file) throws Exception {
        String Nombre = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (Nombre.contains("..")){
                throw new Exception("Nombre de imagen no válido" + Nombre);
            }

            Imagen imagen = imagenRepository.save(Imagen.builder()
                    .nombreImagen(Nombre)
                    .tipoImagen(file.getContentType())
                    .dataImagen(file.getBytes()).build());
            return imagen;
        } catch (Exception e){
            throw new Exception("No se pudo guardar"+ Nombre);
        }
    }

    @Override
    public Imagen verImagen(Long imagenId) {
        return imagenRepository.findById(imagenId).get();
    }

    @Override
    public Imagen obtenerImagen(Long imagenId) throws  Exception {

        return imagenRepository.findById(imagenId)
                .orElseThrow(
                        () -> new Exception("Imagen no encontrado :" + imagenId)
                );

    }

    @Override
    public void eliminarImagen(Long imagenId) {
        Imagen imagen = new Imagen();
        imagen.setId(imagenId);
        imagenRepository.delete(imagen);
    }
}
