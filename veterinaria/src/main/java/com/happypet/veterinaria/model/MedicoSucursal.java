package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MedicoSucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    private boolean titular;
}