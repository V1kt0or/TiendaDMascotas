package com.example.tiendadmascotas.repository;

import com.example.tiendadmascotas.model.Rol;
import com.example.tiendadmascotas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public  Usuario findByUsername(String username);

    public Set<Usuario> findByRol(Rol rol);

    public Set<Usuario> findFirst5ByRol(Rol rol);
}
