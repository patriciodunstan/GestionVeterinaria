package com.happypet.veterinaria.controller;


import com.happypet.veterinaria.dto.*;
import com.happypet.veterinaria.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/sucursal-medicos")
    public List<SucursalMedicoDto> getSucursalAndMedicos(@RequestParam int sucursalId) {
        return reportService.getSucursalAndMedicos(sucursalId);
    }

    @GetMapping("/productos-inventario")
    public List<ProductoDto> getProductosInventario(@RequestParam int sucursalId) {
        return reportService.getProductosInventario(sucursalId);
    }

    @GetMapping("/atencion-branch")
    public List<MascotaAtencionDto> getAtencionByBranch(@RequestParam int sucursalId) {
        return reportService.getAtencionByBranch(sucursalId);
    }

    @GetMapping("/all-pet-type")
    public List<CantidadMascotasDto> getAllPetByType(@RequestParam int sucursalId) {
        return reportService.getAllPetByType(sucursalId);
    }

    @GetMapping("/surgery-branch")
    public List<CirugiaDto> getSurgeryByBranch(@RequestParam int sucursalId) {
        return reportService.getSurgeryByBranch(sucursalId);
    }
}
