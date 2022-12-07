package com.example.tiendadmascotas.model;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "precios")
public class Precio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "descuento")
    private Double descuento;

    @OneToOne(cascade = CascadeType.ALL)
    private Producto producto;
}
