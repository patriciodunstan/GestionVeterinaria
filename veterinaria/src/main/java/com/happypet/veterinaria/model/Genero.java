package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_id")
    private Long id;

    @Column(name = "genero_descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "genero")
    private List<Mascota> mascotas;
}