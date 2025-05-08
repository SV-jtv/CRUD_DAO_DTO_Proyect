package com.example.demo.service.implementation;

import com.example.demo.persistence.dao.interfaces.IPedidoDAO;
import com.example.demo.persistence.entity.PedidoEntity;
import com.example.demo.presentation.dto.PedidoDTO;
import com.example.demo.service.interfaces.IPedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoDAO pedidoDAO;

    @Override
    public List<PedidoDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();

        return pedidoDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, PedidoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO findById(Integer id) {
        Optional<PedidoEntity> userEntity = this.pedidoDAO.findById(id);

        if(userEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            PedidoEntity currentUser = userEntity.get();
            return modelMapper.map(currentUser, PedidoDTO.class);
        } else {
            return new PedidoDTO();
        }
    }

    @Override
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) {

        try{
            ModelMapper modelMapper = new ModelMapper();
            PedidoEntity pedidoEntity = modelMapper.map(pedidoDTO, PedidoEntity.class);
            this.pedidoDAO.save(pedidoEntity);
            return pedidoDTO;
        } catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el usuario" + e.getMessage(), e);
        }
    }

    @Override
    public PedidoDTO updatePedido(PedidoDTO pedidoDTO, Integer id) {

        Optional<PedidoEntity> pedidoEntity = this.pedidoDAO.findById(id);

        if(pedidoEntity.isPresent()){
            PedidoEntity currentPedidoEntity = pedidoEntity.get();
            currentPedidoEntity.setFechaPedido(pedidoDTO.getFechaPedido());
            currentPedidoEntity.setClie(pedidoDTO.getClie());
            currentPedidoEntity.setRep(pedidoDTO.getRep());
            currentPedidoEntity.setFab(pedidoDTO.getFab());
            currentPedidoEntity.setProducto(pedidoDTO.getProducto());
            currentPedidoEntity.setCant(pedidoDTO.getCant());
            currentPedidoEntity.setImporte(pedidoDTO.getImporte());

            this.pedidoDAO.update(currentPedidoEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentPedidoEntity, PedidoDTO.class);
        } else {
            throw new IllegalArgumentException("El usuario no existe");
        }
    }

    @Override
    public String deletePedido(Integer id) {
        Optional<PedidoEntity> userEntity = this.pedidoDAO.findById(id);

        if(userEntity.isPresent()){
            PedidoEntity currentUserEntity = userEntity.get();
            this.pedidoDAO.delete(currentUserEntity);
            return "Usuario con ID " + id +" ha sido eliminado.";
        } else {
            return "El usuario con ID " + id + " no existe.";
        }
    }
}