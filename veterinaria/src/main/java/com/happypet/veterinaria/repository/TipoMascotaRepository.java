package com.happypet.veterinaria.repository;

import com.happypet.veterinaria.model.TipoMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMascotaRepository extends JpaRepository<TipoMascota, Long> {
}
