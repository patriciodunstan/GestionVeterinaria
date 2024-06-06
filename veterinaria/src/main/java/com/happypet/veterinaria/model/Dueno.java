package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "dueno")
public class Dueno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dueno_id")
    private Long id;

    @Column(name = "dueno_rut")
    private String rut;

    @Column(name = "dueno_nombre")
    private String nombre;

    @Column(name = "dueno_apellidos")
    private String apellidos;

    @Column(name = "dueno_email")
    private String email;

    @OneToMany(mappedBy = "dueno")
    private List<Mascota> mascotas;
}

