package com.example.tiendadmascotas;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Rol;
import com.example.tiendadmascotas.services.CategoriaService;
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

    @Autowired
    private CategoriaService categoriaService;

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
        System.out.println("Guardados roles");

        Categoria categoria1 = new Categoria();
        categoria1.setId(1l);
        categoria1.setNombre("Alimentos");

        Categoria categoria2 = new Categoria();
        categoria2.setId(2l);
        categoria2.setNombre("Accesorios para el hogar");

        Categoria categoria3 = new Categoria();
        categoria3.setId(3l);
        categoria3.setNombre("Accesorios para exteriores");

        Categoria categoria4 = new Categoria();
        categoria4.setId(4l);
        categoria4.setNombre("Higiene y bienestar");

        Categoria categoria5 = new Categoria();
        categoria5.setId(5l);
        categoria5.setNombre("Juguetes");

        categoriaService.añadirCategoria(categoria1);
        categoriaService.añadirCategoria(categoria2);
        categoriaService.añadirCategoria(categoria3);
        categoriaService.añadirCategoria(categoria4);
        categoriaService.añadirCategoria(categoria5);
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
