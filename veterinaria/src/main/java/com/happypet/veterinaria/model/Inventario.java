package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventario_id")
    private Long id;

    @Column(name = "inventario_nombre")
    private String nombre;

    @Column(name = "inventario_marca")
    private String marca;

    @Column(name = "inventario_existencia")
    private int existencia;

    @ManyToOne
    @JoinColumn(name = "tipo_producto_id")
    private TipoProducto tipoProducto;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;
}
