package com.alan.projeto.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alan.projeto.domain.entity.Cliente;
import com.alan.projeto.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
    
    List<Pedido> findByCliente(Cliente cliente);
}
