package com.example.tiendadmascotas.UnitTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.example.tiendadmascotas.model.Categoria;
import com.example.tiendadmascotas.model.Producto;
import com.example.tiendadmascotas.model.Usuario;
import com.example.tiendadmascotas.repository.ProductoRepository;
import com.example.tiendadmascotas.repository.UsuarioRepository;
import com.example.tiendadmascotas.services.implementation.ProductoServiceImp;
import com.example.tiendadmascotas.services.implementation.UsuarioServiceImp;
import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PruebasUnitariasProducto {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImp productoServiceImp;

    private Producto producto1;
    private Producto producto2;

    @BeforeEach
    void setup() throws ParseException {
        producto1 = Producto.builder()
                .id(1l)
                .nombre("Collar")
                .cantidad(15)
                .detalles("Collar para perros")
                .disponible(true)
                .categoria(Categoria.builder().id(1L).nombre("Cosmetico").build())
                .build();

        producto2 = Producto.builder()
                .nombre("Galletas")
                .cantidad(10)
                .detalles("Galletas para perros")
                .disponible(true)
                .categoria(Categoria.builder().id(2L).nombre("Comida").build())
                .build();
    }

    @DisplayName("Test unitario para guardar un producto")
    @Test
    void testGuardarProducto() throws Exception {
        //given
        given(productoRepository.save(producto1)).willReturn(producto1);

        //when
        Producto productoGuardado = productoServiceImp.guardarProducto(producto1);

        //then
        assertThat(productoGuardado).isNotNull();
    }

    @DisplayName("Test unitario para ver un producto")
    @Test
    void testVerProducto() throws Exception {
        //given
        given(productoRepository.findById(1l)).willReturn(Optional.of(producto1));

        //when
        Producto productoVisto = productoServiceImp.verProducto(producto1.getId());

        //then
        assertThat(productoVisto).isNotNull();
    }

    @DisplayName("Test unitario para listar los producto")
    @Test
    void testVerProductos() throws Exception {
        //given
        given(productoRepository.findAll()).willReturn(List.of(producto1,producto2));

        //when
        List<Producto> productos = productoServiceImp.verTodosProductos();

        //then
        assertThat(productos).isNotNull();
        assertThat(productos.size()).isEqualTo(2);
    }





}
