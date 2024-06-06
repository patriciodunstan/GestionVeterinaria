package com.happypet.veterinaria.repository;

import com.happypet.veterinaria.model.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DuenoRepository extends JpaRepository<Dueno, Long> {
}
