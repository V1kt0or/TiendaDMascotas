package com.example.tiendadmascotas.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "detalles")
    private String detalles;

    @Column(name = "disponible")
    private Boolean disponible;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @OneToOne(mappedBy = "producto")
    private Precio precio;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "producto")
    @JsonIgnore
    private Set<CarritoProducto> carritoProductos = new HashSet<>();

    @OneToMany(mappedBy = "producto",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Imagen> imagenes = new LinkedHashSet<>();
}
