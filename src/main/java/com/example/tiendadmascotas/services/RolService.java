package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Rol;
import com.example.tiendadmascotas.model.Usuario;

public interface RolService {

    public Rol guardarRol(Rol rol);

    public Rol obtenerRol(String nombre);

    public void eliminarRol(Long rolId);
}
