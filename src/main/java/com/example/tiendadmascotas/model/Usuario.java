package com.example.tiendadmascotas.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "edad",nullable = false)
    private Integer edad;

    @Column(name = "direccion",nullable = false)
    private String direccion;

    @Column(name = "correo",nullable = false)
    private String correo;

    @Column(name = "fechaRegistro",nullable = false)
    private Date fechaRegistro;

    @Column(name = "activo")
    private Boolean activo = true;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rol rol;

    @OneToOne(mappedBy = "usuario")
    private Carrito carrito;
}
