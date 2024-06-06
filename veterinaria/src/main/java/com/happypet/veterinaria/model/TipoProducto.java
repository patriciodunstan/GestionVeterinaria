package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tipo_producto")
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_producto_id")
    private Long id;

    @Column(name = "tipo_producto_descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tipoProducto")
    private List<Inventario> inventarios;
}

