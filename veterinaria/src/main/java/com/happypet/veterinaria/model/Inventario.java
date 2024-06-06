package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private int existencia;

    @ManyToOne
    @JoinColumn(name = "tipo_producto_id")
    private TipoProducto tipoProducto;
}
