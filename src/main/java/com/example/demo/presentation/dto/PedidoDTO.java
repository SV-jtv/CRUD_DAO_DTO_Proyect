package com.example.demo.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private Integer numPedido;
    private LocalDate fechaPedido;
    private Short clie;
    private Short rep;
    private String fab;
    private String producto;
    private Short cant;
    private BigDecimal importe;
}
