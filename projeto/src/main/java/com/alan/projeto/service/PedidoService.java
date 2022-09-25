package com.alan.projeto.service;

import com.alan.projeto.domain.entity.Pedido;
import com.alan.projeto.rest.dto.PedidoDTO;

public interface PedidoService {
    
    Pedido salvar(PedidoDTO dto);
}
