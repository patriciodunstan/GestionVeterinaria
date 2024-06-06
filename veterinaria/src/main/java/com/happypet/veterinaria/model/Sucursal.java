package com.happypet.veterinaria.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sucursal_id")
    private Long id;

    @Column(name = "sucursal_nombre")
    private String nombre;

    @Column(name = "sucursal_direccion")
    private String direccion;

    @Column(name = "sucursal_telefono")
    private String telefono;

    @OneToMany(mappedBy = "sucursal")
    private List<Inventario> inventarios;

    @OneToMany(mappedBy = "sucursal")
    private List<Atencion> atenciones;

    @OneToMany(mappedBy = "sucursal")
    private List<MedicoSucursal> medicoSucursales;

}