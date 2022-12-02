package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Rol;
import com.example.tiendadmascotas.model.Usuario;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario) throws Exception;

    public Usuario obtenerUsuario(String username);


    public void eliminarUsuario(Long usuarioId);
}
