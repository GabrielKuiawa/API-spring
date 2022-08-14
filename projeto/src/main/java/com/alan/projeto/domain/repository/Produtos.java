package com.alan.projeto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alan.projeto.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{
    
}
