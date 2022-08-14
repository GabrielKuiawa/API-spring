package com.alan.projeto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alan.projeto.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
    
}
