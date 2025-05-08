package com.example.demo.persistence.dao.implementation;

import com.example.demo.persistence.dao.interfaces.IPedidoDAO;
import com.example.demo.persistence.entity.PedidoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoDaoImpl implements IPedidoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<PedidoEntity> findAll() {
        return this.em.createQuery("SELECT p FROM PedidoEntity p", PedidoEntity.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PedidoEntity> findById(Integer id) {
        return Optional.ofNullable(this.em.find(PedidoEntity.class, id));
    }

    @Override
    @Transactional
    public void save(PedidoEntity pedidoEntity) {
        if (pedidoEntity.getNumPedido() == null) {
            this.em.persist(pedidoEntity);
        } else {
            this.em.merge(pedidoEntity);
        }
        this.em.flush();
    }

    @Override
    @Transactional
    public void update(PedidoEntity pedidoEntity) {
        this.em.merge(pedidoEntity);
    }

    @Override
    @Transactional
    public void delete(PedidoEntity pedidoEntity) {
        PedidoEntity managed = this.em.contains(pedidoEntity) ? pedidoEntity : this.em.merge(pedidoEntity);
        this.em.remove(managed);
    }
}
