package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private Long id;

    @Column(name = "medico_rut")
    private String rut;

    @Column(name = "medico_nombre")
    private String nombre;

    @Column(name = "medico_apellidos")
    private String apellidos;

    @Column(name = "medico_email")
    private String email;

    @OneToMany(mappedBy = "medico")
    private List<Atencion> atenciones;

    @OneToMany(mappedBy = "medico")
    private List<MedicoSucursal> medicoSucursales;
}

