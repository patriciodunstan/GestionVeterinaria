package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tipo_atencion")
public class TipoAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_atencion_id")
    private Long id;

    @Column(name = "tipo_atencion_descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tipoAtencion")
    private List<Atencion> atenciones;
}