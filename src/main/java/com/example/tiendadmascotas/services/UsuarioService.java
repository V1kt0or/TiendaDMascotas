package com.example.tiendadmascotas.services;

import com.example.tiendadmascotas.model.Rol;
import com.example.tiendadmascotas.model.Usuario;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario) throws Exception;

    public Usuario obtenerUsuario(String username);

    public  Set<Usuario> onbtenerUsuariosRol(Long rolId);

    public  Set<Usuario> onbtener5UsuariosRol(Long rolId);

    public void eliminarUsuario(Long usuarioId);
}
