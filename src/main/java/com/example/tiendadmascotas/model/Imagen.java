package com.example.tiendadmascotas.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nombreImagen;

    private String tipoImagen;

    @Lob
    private byte[] dataImagen;

    @ManyToOne(fetch = FetchType.EAGER)
    private Producto producto;
}
