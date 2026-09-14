package com.erp.backend.service;

import com.erp.backend.entity.Empresas;
import com.erp.backend.exception.ResourceNotFoundException;
import com.erp.backend.repository.EmpresasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresasService {

    private final EmpresasRepository empresaRepository;

    public EmpresasService(EmpresasRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Transactional(readOnly = true)
    public List<Empresas> findAll() {
        return empresaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Empresas findById(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con el ID: " + id));
    }

    @Transactional
    public Empresas save(Empresas empresa) {
        return empresaRepository.save(empresa);
    }
}