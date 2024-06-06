package com.happypet.veterinaria.repository;

import com.happypet.veterinaria.model.TipoAtencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoAtencionRepository extends JpaRepository<TipoAtencion, Long> {
}
