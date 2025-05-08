package com.example.demo.presentation.controller;

import com.example.demo.presentation.dto.PedidoDTO;
import com.example.demo.service.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    // Find All
    @GetMapping("/find")
    public ResponseEntity<List<PedidoDTO>> findAll() {
        return new ResponseEntity<>(pedidoService.findAll(), HttpStatus.OK);
    }

    // Find by ID
    @GetMapping("/find/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(pedidoService.findById(id), HttpStatus.OK);
    }

    // Create Pedido
    @PostMapping("/create")
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidosDTO) {
        return new ResponseEntity<>(pedidoService.createPedido(pedidosDTO), HttpStatus.CREATED);
    }

    // Update Pedido
    @PutMapping("/update/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@RequestBody PedidoDTO pedidosDTO, @PathVariable Integer id) {
        return new ResponseEntity<>(pedidoService.updatePedido(pedidosDTO, id), HttpStatus.OK);
    }

    // Delete Pedido
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Integer id) {
        pedidoService.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}