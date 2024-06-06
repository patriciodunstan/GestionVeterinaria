package com.happypet.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mascota_id")
    private Long id;

    @Column(name = "mascota_nombre")
    private String nombre;

    @Column(name = "mascota_raza")
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

    @OneToMany(mappedBy = "mascota")
    private List<Atencion> atenciones;
}
