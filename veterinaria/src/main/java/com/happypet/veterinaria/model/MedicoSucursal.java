package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medico_sucursal")
public class MedicoSucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_sucursal_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @Column(name = "titular")
    private boolean titular;
}