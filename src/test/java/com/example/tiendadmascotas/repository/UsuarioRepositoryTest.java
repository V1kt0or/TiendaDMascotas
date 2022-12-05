package com.example.tiendadmascotas.repository;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.tiendadmascotas.TiendaDMascotasApplication;
import com.example.tiendadmascotas.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    @BeforeEach
    void setup(){
        usuario = Usuario.builder()
                .nombre("Christian")
                .apellidoMaterno("Ramirez")
                .apellidoPaterno("Suares")
                .correo("c1@gmail.com")
                .fechaRegistro(new Date())
                .edad(25)
                .username("usuario1")
                .direccion("casa 1")
                .password("12345")
                .build();
    }

    @DisplayName("Test para guardar un usuario")
    @Test
    void testGuardarEmpleado(){
        //given - dado o condición previa o configuración
        Usuario usuario1 = Usuario.builder()
                .nombre("Christiana")
                .apellidoMaterno("Santos")
                .apellidoPaterno("Fal")
                .correo("c2@gmail.com")
                .fechaRegistro(new Date())
                .edad(20)
                .username("usuario2")
                .direccion("casa 2")
                .password("12345")
                .build();

        //when - acción o el comportamiento que vamos a probar
        Usuario usuarioGuardado = usuarioRepository.save(usuario1);

        //then - verificar la salida
        assertThat(usuarioGuardado).isNotNull();
        assertThat(usuarioGuardado.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar a los usuarios")
    @Test
    void testListarEmpleados(){
        //given
        Usuario usuario1 = Usuario.builder()
                .nombre("Christiana")
                .apellidoMaterno("Santos")
                .apellidoPaterno("Fal")
                .correo("c2@gmail.com")
                .fechaRegistro(new Date())
                .edad(20)
                .username("usuario2")
                .direccion("casa 2")
                .password("12345")
                .build();

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario);

        //when
        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        //then
        assertThat(listaUsuarios).isNotNull();
        assertThat(listaUsuarios.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener un usuaerio por ID")
    @Test
    void testObtenerEmpleadoPorId(){
        usuarioRepository.save(usuario);

        //when - comportamiento o accion que vamos a probar
        Usuario usuarioBD = usuarioRepository.findById(usuario.getId()).get();

        //then
        assertThat(usuarioBD).isNotNull();
    }

    @DisplayName("Test para actualizar un usuario")
    @Test
    void testActualizarEmpleado(){
        usuarioRepository.save(usuario);

        //when
        Usuario usuarioGuardado = usuarioRepository.findById(usuario.getId()).get();
        usuarioGuardado.setCorreo("c232@gmail.com");
        usuarioGuardado.setNombre("Christian Raul");
        usuarioGuardado.setApellidoMaterno("Ramirezas");
        Usuario usuarioActualizado = usuarioRepository.save(usuarioGuardado);

        //then
        assertThat(usuarioActualizado.getCorreo()).isEqualTo("c232@gmail.com");
        assertThat(usuarioActualizado.getNombre()).isEqualTo("Christian Raul");
    }

    @DisplayName("Test para eliminar un empleado")
    @Test
    void testEliminarEmpleado(){
        usuarioRepository.save(usuario);

        //when
        usuarioRepository.deleteById(usuario.getId());
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getId());

        //then
        assertThat(usuarioOptional).isEmpty();
    }


    @DisplayName("Test para buscar usuario por nombre")
    @Test
    void testBuscarUsuario(){
        usuarioRepository.save(usuario);

        //when
        Usuario usuarioBuscado = usuarioRepository.findByUsername("usuario1");

        //then
        assertThat(usuarioBuscado).isEqualTo(usuario);
    }
}
