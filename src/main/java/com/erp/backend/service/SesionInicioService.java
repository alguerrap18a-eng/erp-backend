package com.erp.backend.service;

import com.erp.backend.entity.SesionInicio;
import com.erp.backend.exception.ResourceNotFoundException;
import com.erp.backend.repository.SesionInicioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SesionInicioService {

    private final SesionInicioRepository sesionInicioRepository;

    public SesionInicioService(SesionInicioRepository sesionInicioRepository) {
        this.sesionInicioRepository = sesionInicioRepository;
    }

    @Transactional(readOnly = true)
    public List<SesionInicio> findAll() {
        return sesionInicioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public SesionInicio findById(Long id) {
        return sesionInicioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sesión de inicio no encontrada con el ID: " + id));
    }

    @Transactional
    public SesionInicio save(SesionInicio sesionInicio) {
        return sesionInicioRepository.save(sesionInicio);
    }
}