package com.example.demo.service.interfaces;

import com.example.demo.presentation.dto.PedidoDTO;

import java.util.List;

public interface IPedidoService {
    List<PedidoDTO> findAll();
    PedidoDTO findById(Integer id);
    PedidoDTO createPedido(PedidoDTO pedidoDTO);
    PedidoDTO updatePedido(PedidoDTO pedidoDTO, Integer id);
    String deletePedido(Integer id);
}

