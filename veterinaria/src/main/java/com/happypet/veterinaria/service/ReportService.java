package com.happypet.veterinaria.service;


import com.happypet.veterinaria.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<SucursalMedicoDto> getSucursalAndMedicos(int sucursalId) {
        String sql = "SELECT s.sucursal_nombre AS sucursal, m.medico_nombre AS medico " +
                "FROM sucursal s " +
                "JOIN medico_sucursal ms ON s.sucursal_id = ms.sucursal_id " +
                "JOIN medico m ON ms.medico_id = m.medico_id " +
                "WHERE s.sucursal_id = ?";

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, sucursalId);
        return results.stream().map(this::mapToSucursalMedicoDto).collect(Collectors.toList());
    }

    public List<ProductoDto> getProductosInventario(int sucursalId) {
        String sql = "SELECT i.inventario_nombre AS producto, i.inventario_marca AS marca, i.inventario_existencia AS stock " +
                "FROM inventario i " +
                "WHERE i.sucursal_id = ?";

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, sucursalId);
        return results.stream().map(this::mapToProductoDto).collect(Collectors.toList());
    }

    public List<MascotaAtencionDto> getAtencionByBranch(int sucursalId) {
        String sql = "SELECT m.mascota_nombre AS mascota, ta.tipo_atencion_descripcion AS atencion " +
                "FROM mascota m " +
                "JOIN atencion a ON m.mascota_id = a.mascota_id " +
                "JOIN tipo_atencion ta ON a.tipo_atencion_id = ta.tipo_atencion_id " +
                "WHERE a.sucursal_id = ?";

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, sucursalId);
        return results.stream().map(this::mapToMascotaAtencionDto).collect(Collectors.toList());
    }

    public List<CantidadMascotasDto> getAllPetByType(int sucursalId) {
        String sql = "SELECT s.sucursal_nombre AS sucursal, tm.tipo_mascota_descripcion AS tipo_mascota, COUNT(m.mascota_id) AS cantidad " +
                "FROM sucursal s " +
                "JOIN mascota m ON s.sucursal_id = m.sucursal_id " +
                "JOIN tipo_mascota tm ON m.tipo_mascota_id = tm.tipo_mascota_id " +
                "GROUP BY s.sucursal_nombre, tm.tipo_mascota_descripcion";

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, sucursalId);
        return results.stream().map(this::mapToCantidadMascotasDto).collect(Collectors.toList());
    }

    public List<CirugiaDto> getSurgeryByBranch(int sucursalId) {
        String sql = "SELECT s.sucursal_nombre AS sucursal, m.medico_nombre AS medico, COUNT(a.atencion_id) AS cantidad_cirugias " +
                "FROM atencion a " +
                "JOIN medico m ON a.medico_id = m.medico_id " +
                "JOIN sucursal s ON a.sucursal_id = s.sucursal_id " +
                "WHERE a.tipo_atencion_id = (SELECT tipo_atencion_id FROM tipo_atencion WHERE tipo_atencion_descripcion = 'Cirugia') " +
                "GROUP BY s.sucursal_nombre, m.medico_nombre " +
                "ORDER BY cantidad_cirugias DESC " +
                "LIMIT 10";

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, sucursalId);
        return results.stream().map(this::mapToCirugiaDto).collect(Collectors.toList());
    }

    private SucursalMedicoDto mapToSucursalMedicoDto(Map<String, Object> result) {
        SucursalMedicoDto dto = new SucursalMedicoDto();
        dto.setSucursal((String) result.get("sucursal"));
        dto.setMedico((String) result.get("medico"));
        return dto;
    }

    private ProductoDto mapToProductoDto(Map<String, Object> result) {
        ProductoDto dto = new ProductoDto();
        dto.setNombre((String) result.get("producto"));
        dto.setMarca((String) result.get("marca"));
        dto.setStock((Integer) result.get("stock"));
        return dto;
    }

    private MascotaAtencionDto mapToMascotaAtencionDto(Map<String, Object> result) {
        MascotaAtencionDto dto = new MascotaAtencionDto();
        dto.setMascota((String) result.get("mascota"));
        dto.setAtencion((String) result.get("atencion"));
        return dto;
    }

    private CantidadMascotasDto mapToCantidadMascotasDto(Map<String, Object> result) {
        CantidadMascotasDto dto = new CantidadMascotasDto();
        dto.setSucursal((String) result.get("sucursal"));
        dto.setTipoMascota((String) result.get("tipo_mascota"));
        dto.setCantidad(((Number) result.get("cantidad")).intValue());
        return dto;
    }

    private CirugiaDto mapToCirugiaDto(Map<String, Object> result) {
        CirugiaDto dto = new CirugiaDto();
        dto.setSucursal((String) result.get("sucursal"));
        dto.setMedico((String) result.get("medico"));
        dto.setCantidadCirugias(((Number) result.get("cantidad_cirugias")).intValue());
        return dto;
    }

}
