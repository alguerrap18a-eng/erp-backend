package com.erp.backend.service;

import com.erp.backend.entity.Usuarios;
import com.erp.backend.exception.ResourceNotFoundException;
import com.erp.backend.repository.UsuariosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Transactional(readOnly = true)
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuarios findById(Long id) {
        return usuariosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + id));
    }

    @Transactional
    public Usuarios save(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }
}