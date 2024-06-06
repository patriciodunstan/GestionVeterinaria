package com.happypet.veterinaria.repository;

import com.happypet.veterinaria.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
