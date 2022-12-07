package com.example.tiendadmascotas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "carritos")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidadTotal")
    private Integer cantidadTotal;

    @Column(name = "precioTotal")
    private Double precioTotal;


    @OneToOne(mappedBy = "carrito")
    @JsonIgnore
    private Pago pago;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "carrito")
    @JsonIgnore
    private Set<CarritoProducto> carritoProductos = new HashSet<>();
}
