package com.example.tiendadmascotas.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "pagos")

public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private Double monto;

    @OneToOne(cascade = CascadeType.ALL)
    private Carrito carrito;

    @OneToOne(mappedBy = "pago")
    private  Pedido pedido;
}
