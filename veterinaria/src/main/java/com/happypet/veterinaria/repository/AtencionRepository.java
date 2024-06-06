package com.happypet.veterinaria.repository;

import com.happypet.veterinaria.model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long> {
}
