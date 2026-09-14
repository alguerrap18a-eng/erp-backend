package com.erp.backend.service;

import com.erp.backend.entity.Sucursales;
import com.erp.backend.exception.ResourceNotFoundException;
import com.erp.backend.repository.SucursalesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SucursalesService {

    private final SucursalesRepository sucursalesRepository;

    public SucursalesService(SucursalesRepository sucursalesRepository) {
        this.sucursalesRepository = sucursalesRepository;
    }

    @Transactional(readOnly = true)
    public List<Sucursales> findAll() {
        return sucursalesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Sucursales findById(Long id) {
        return sucursalesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal no encontrada con el ID: " + id));
    }

    @Transactional
    public Sucursales save(Sucursales sucursal) {
        return sucursalesRepository.save(sucursal);
    }
}