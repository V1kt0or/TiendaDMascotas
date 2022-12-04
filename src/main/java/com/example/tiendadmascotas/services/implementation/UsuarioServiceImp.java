package com.example.tiendadmascotas.services.implementation;

import com.example.tiendadmascotas.model.Rol;
import com.example.tiendadmascotas.model.Usuario;
import com.example.tiendadmascotas.repository.RolRepository;
import com.example.tiendadmascotas.repository.UsuarioRepository;
import com.example.tiendadmascotas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta adentro");
        }
        else {
            usuarioLocal=usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Set<Usuario> onbtenerUsuariosRol(Long rolId) {
        Rol rol = new Rol();
        rol.setId(rolId);
        return usuarioRepository.findByRol(rol);
    }

    @Override
    public Set<Usuario> onbtener5UsuariosRol(Long rolId) {
        Rol rol = new Rol();
        rol.setId(rolId);
        return usuarioRepository.findFirst5ByRol(rol);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        new Usuario();
        Usuario usuario;
        usuario = usuarioRepository.findById(usuarioId).get();
        usuario.setActivo(false);
        usuarioRepository.save(usuario);

    }
}
