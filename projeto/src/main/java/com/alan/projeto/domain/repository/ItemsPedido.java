package com.alan.projeto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alan.projeto.domain.entity.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer>{
    
}
