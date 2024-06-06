package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaRealizacion;
    private LocalDateTime fechaProximaRevision;
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