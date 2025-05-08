package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.PedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends CrudRepository<PedidoEntity, Integer> {
}