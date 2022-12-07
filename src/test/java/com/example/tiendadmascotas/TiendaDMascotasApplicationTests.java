package com.example.tiendadmascotas;

import com.example.tiendadmascotas.controller.CategoriaController;
import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Usuario;
import com.example.tiendadmascotas.repository.CategoríaRepository;
import com.example.tiendadmascotas.repository.UsuarioRepository;
<<<<<<< Updated upstream
import com.example.tiendadmascotas.repository.UsuarioRepositoryTest;
=======
import org.hamcrest.CoreMatchers;
>>>>>>> Stashed changes
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class TiendaDMascotasApplicationTests {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoríaRepository categoríaRepository;

    @Autowired
    private CategoriaController categoriaController;

    private Usuario usuario;

    @BeforeEach
    void setup(){
        usuarioRepository.deleteAll();
        categoríaRepository.deleteAll();
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

    @DisplayName("Test en controller para guardar categorias")
    @Test
    void testGuardarCategoria(){
        Categoria categoria = Categoria.builder().id(1l).nombre("Comida").build();

        //when - acción o el comportamiento que vamos a probar
        Categoria categoraGuardada = categoriaController.guardarCategoria(categoria);

        //then - verificar la salida
        assertThat(categoraGuardada).isNotNull();
        assertThat(categoraGuardada.getId()).isGreaterThan(0);
    }

<<<<<<< Updated upstream
    @Test
=======
    @DisplayName("Test en controller para eliminar una categoria")
    @Test
    void testEliminarCategoria(){
        Categoria categoria = Categoria.builder().id(1l).nombre("Comida").build();
        categoríaRepository.save(categoria);

        //when
        categoriaController.eliminarCategoria(categoria.getId());
        Optional<Categoria> categoriaOptional = categoríaRepository.findById(categoria.getId());

        //then
        assertThat(categoriaOptional).isEmpty();
    }

    @DisplayName("Test en controller para listar categorias")
    @Test
    void testListarCategorias(){
        Categoria categoria = Categoria.builder().id(1l).nombre("Comida").build();
        categoríaRepository.save(categoria);

        Categoria categoria1 = Categoria.builder().id(2l).nombre("Juguetes").build();
        categoríaRepository.save(categoria1);

        //when
        List<Categoria> listaCategoriass = categoríaRepository.findAll();

        //then
        assertThat(listaCategoriass).isNotNull();
        assertThat(listaCategoriass.size()).isEqualTo(2);
    }
    /*@Test
>>>>>>> Stashed changes
    void contextLoads() {

    }

}
