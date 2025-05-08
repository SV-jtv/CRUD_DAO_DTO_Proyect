package com.example.demo.persistence.dao.interfaces;

import com.example.demo.persistence.entity.PedidoEntity;

import java.util.List;
import java.util.Optional;

public interface IPedidoDAO {
    List<PedidoEntity> findAll();
    Optional<PedidoEntity> findById(Integer id);
    void save(PedidoEntity pedidoEntity);
    void update(PedidoEntity pedidoEntity);
    void delete(PedidoEntity pedidoEntity);
}