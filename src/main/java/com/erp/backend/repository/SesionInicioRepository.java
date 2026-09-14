package com.erp.backend.repository;

import com.erp.backend.entity.SesionInicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionInicioRepository extends JpaRepository<SesionInicio, Long> {
}