package com.example.tiendadmascotas.controller;

import com.example.tiendadmascotas.model.Rol;
import com.example.tiendadmascotas.model.Usuario;
import com.example.tiendadmascotas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        return usuarioService.guardarUsuario(usuario);
        //FALTA AÑADIR EXCEPCION PARA QUE NO AÑADA USUARIOS CON EL MISMO NOMBRE  ¿O SE HARÁ EN EL FRONT?
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String usuarioId){
        return usuarioService.obtenerUsuario(usuarioId);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }
}
