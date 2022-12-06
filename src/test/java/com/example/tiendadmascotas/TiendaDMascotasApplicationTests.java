package com.example.tiendadmascotas;

import com.example.tiendadmascotas.model.Usuario;
import com.example.tiendadmascotas.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TiendaDMascotasApplicationTests {


    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    @BeforeEach
    void setup(){
        usuarioRepository.deleteAll();
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

    @DisplayName("Test para listar a los usuarios")
    @Test
    void testListarUsuarios(){
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

    @DisplayName("Test para guardar un usuario")
    @Test
    void testGuardarUsuario(){
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



    @DisplayName("Test para obtener un usuaerio por ID")
    @Test
    void testObtenerUsuarioPorId(){
        usuarioRepository.save(usuario);

        //when - comportamiento o accion que vamos a probar
        Usuario usuarioBD = usuarioRepository.findById(usuario.getId()).get();

        //then
        assertThat(usuarioBD).isNotNull();
    }

    @DisplayName("Test para actualizar un usuario")
    @Test
    void testActualizarUsuario(){
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

    @DisplayName("Test para eliminar un usuario")
    @Test
    void testEliminarUsuario(){
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

        Usuario usuario1 = Usuario.builder()
                .nombre("Christi")
                .apellidoMaterno("Santi")
                .apellidoPaterno("Fal")
                .correo("c2@gmail.com")
                .fechaRegistro(new Date())
                .edad(20)
                .username("usuario33")
                .direccion("casa 2")
                .password("12345")
                .build();
        usuarioRepository.save(usuario1);

        //when
        Optional<Usuario> usuarioBuscado = Optional.ofNullable(usuarioRepository.findByUsername("usuario33"));

        //then
        assertThat(usuarioBuscado).isNotEmpty();
    }



    /*@Test
    void contextLoads() {

    }*/

}
