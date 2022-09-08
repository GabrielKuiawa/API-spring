package com.alan.projeto.service.impl;

import org.springframework.stereotype.Service;

import com.alan.projeto.domain.repository.Pedidos;
import com.alan.projeto.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
    
    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
