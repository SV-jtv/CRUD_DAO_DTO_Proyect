package com.example.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
public class PedidoEntity {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private String email;
    private byte age;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_pedido")
    private Integer numPedido;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "clie")
    private Short clie;

    @Column(name = "rep")
    private Short rep;

    @Column(name = "fab", length = 3)
    private String fab;

    @Column(name = "producto", length = 5)
    private String producto;

    @Column(name = "cant")
    private Short cant;

    @Column(name = "importe", precision = 7, scale = 2)
    private BigDecimal importe;
}
