package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String raza;

    @ManyToOne
    @JoinColumn(name = "dueno_id")
    private Dueno dueno;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "tipo_mascota_id")
    private TipoMascota tipoMascota;
}
