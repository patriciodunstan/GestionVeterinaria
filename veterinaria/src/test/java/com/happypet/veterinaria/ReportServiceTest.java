package com.happypet.veterinaria;

import com.happypet.veterinaria.dto.MascotaAtencionDto;
import com.happypet.veterinaria.dto.ProductoDto;
import com.happypet.veterinaria.dto.SucursalMedicoDto;
import com.happypet.veterinaria.service.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class ReportServiceTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ReportService reportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSucursalAndMedicos(){
        // Arrange
        List<Map<String, Object>> mockResult = new ArrayList<>();
        Map<String, Object> row = new HashMap<>();
        row.put("sucursal", "Sucursal Centro");
        row.put("medico", "Dr. Juan Pérez");
        mockResult.add(row);
        when(jdbcTemplate.queryForList(any(String.class), anyInt())).thenReturn(mockResult);

        // Act
        List<SucursalMedicoDto> result = reportService.getSucursalAndMedicos(1);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Sucursal Centro", result.get(0).getSucursal());
        assertEquals("Dr. Juan Pérez", result.get(0).getMedico());
    }

    @Test
    void testGetProductosInventario() {
        // Arrange
        List<Map<String, Object>> mockResult = new ArrayList<>();
        Map<String, Object> row = new HashMap<>();
        row.put("producto", "Antipulgas");
        row.put("marca", "Bayer");
        row.put("stock", 50);
        mockResult.add(row);
        when(jdbcTemplate.queryForList(any(String.class), anyInt())).thenReturn(mockResult);

        // Act
        List<ProductoDto> result = reportService.getProductosInventario(1);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Antipulgas", result.get(0).getNombre());
        assertEquals("Bayer", result.get(0).getMarca());
        assertEquals(50, result.get(0).getStock());
    }

    @Test
    void testGetAtencionByBranch() {
        // Arrange
        List<Map<String, Object>> mockResult = new ArrayList<>();
        Map<String, Object> row = new HashMap<>();
        row.put("mascota", "Firulais");
        row.put("atencion", "Consulta");
        mockResult.add(row);
        when(jdbcTemplate.queryForList(any(String.class), anyInt())).thenReturn(mockResult);

        // Act
        List<MascotaAtencionDto> result = reportService.getAtencionByBranch(1);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Firulais", result.get(0).getMascota());
        assertEquals("Consulta", result.get(0).getAtencion());
    }
}
