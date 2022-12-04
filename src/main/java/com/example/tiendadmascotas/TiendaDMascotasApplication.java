package com.example.tiendadmascotas;

import com.example.tiendadmascotas.model.Rol;
import com.example.tiendadmascotas.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TiendaDMascotasApplication implements CommandLineRunner {

    @Autowired
    private RolService rolService;

    public static void main(String[] args) {
        SpringApplication.run(TiendaDMascotasApplication.class, args);
    }

    @Override
    public void run (String... args) throws Exception {

        Rol rol = new Rol();
        rol.setId(1L);
        rol.setRolNombre("ADMIN");

        Rol rol1 = new Rol();
        rol1.setId(2L);
        rol1.setRolNombre("NORMAL");


        rolService.guardarRol(rol);
        rolService.guardarRol(rol1);
        System.out.println("Guardados");
/*
        Set<UsuarioRol> usuarioRoles = new HashSet<>();
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuario);
        usuarioRoles.add(usuarioRol);

        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuarioRoles);
        System.out.println(usuarioGuardado.getUsername());*/
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("/**").allowedMethods("*").allowedHeaders("*");
            }
        };
    }
}
