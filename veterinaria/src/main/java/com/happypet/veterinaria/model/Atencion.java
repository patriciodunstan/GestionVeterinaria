package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "atencion")
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atencion_id")
    private Long id;

    @Column(name = "fecha_realizacion")
    private LocalDateTime fechaRealizacion;

    @Column(name = "fecha_proxima_revision")
    private LocalDateTime fechaProximaRevision;

    @Column(name = "box_atencion")
    private String boxAtencion;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "tipo_atencion_id")
    private TipoAtencion tipoAtencion;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;
}