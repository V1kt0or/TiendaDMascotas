package com.example.tiendadmascotas.repository;

import com.example.tiendadmascotas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
