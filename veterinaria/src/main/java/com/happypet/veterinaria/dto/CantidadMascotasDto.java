package com.happypet.veterinaria.dto;

import lombok.Data;

@Data
public class CantidadMascotasDto {
    private String sucursal;
    private String tipoMascota;
    private int cantidad;
}