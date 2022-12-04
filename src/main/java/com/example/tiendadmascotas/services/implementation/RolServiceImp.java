package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Rol;
import com.example.tiendadmascotas.repository.RolRepository;
import com.example.tiendadmascotas.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImp implements RolService {

    @Autowired
    public RolRepository rolRepository;

    @Override
    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol obtenerRol(String  nombre) {
        return rolRepository.findByRolNombre(nombre);
    }

    @Override
    public void eliminarRol(Long rolId) {

    }
}
