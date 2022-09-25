package com.alan.projeto.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alan.projeto.domain.entity.Cliente;
import com.alan.projeto.domain.entity.ItemPedido;
import com.alan.projeto.domain.entity.Pedido;
import com.alan.projeto.domain.entity.Produto;
import com.alan.projeto.domain.repository.Clientes;
import com.alan.projeto.domain.repository.ItemsPedido;
import com.alan.projeto.domain.repository.Pedidos;
import com.alan.projeto.domain.repository.Produtos;
import com.alan.projeto.exception.RegraNegocioException;
import com.alan.projeto.rest.dto.ItemPedidoDTO;
import com.alan.projeto.rest.dto.PedidoDTO;
import com.alan.projeto.service.PedidoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    
    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItemsPedido itemsPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository.findById(idCliente)
            .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));


        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemsPedidos = converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemsPedidoRepository.saveAll(itemsPedidos);
        pedido.setItens(itemsPedidos);

        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido ,List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem items.");
        }

        return (List<ItemPedido>) items.stream().map(dto -> {
            Integer idProduto = dto.getProduto();
            Produto produto = produtosRepository
                .findById(idProduto)
                .orElseThrow(() -> new RegraNegocioException("Código de produto inválido: " + idProduto));

            ItemPedido itemPedido = new  ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            
            return itemPedido;
        }).collect(Collectors.toList());
    }
}
