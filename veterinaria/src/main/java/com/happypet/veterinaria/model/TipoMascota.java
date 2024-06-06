package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tipo_mascota")
public class TipoMascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_mascota_id")
    private Long id;

    @Column(name = "tipo_mascota_descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tipoMascota")
    private List<Mascota> mascotas;
}