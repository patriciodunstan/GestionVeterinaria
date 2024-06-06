package com.happypet.veterinaria.repository;

import com.happypet.veterinaria.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
}
