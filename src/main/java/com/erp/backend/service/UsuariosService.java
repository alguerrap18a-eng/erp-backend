package com.erp.backend.service;

import com.erp.backend.entity.Usuarios;
import com.erp.backend.exception.ResourceNotFoundException;
import com.erp.backend.repository.UsuariosRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;
    private final PasswordEncoder passwordEncoder; // <-- 1. Declarar el encriptador

    // 2. Inyectar ambos en el constructor
    public UsuariosService(UsuariosRepository usuariosRepository, PasswordEncoder passwordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
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
        // 3. Encriptar la contraseña en texto plano antes de persistirla en la BD
        String passwordPlano = usuario.getPasswordHash();
        String passwordSeguro = passwordEncoder.encode(passwordPlano);
        usuario.setPasswordHash(passwordSeguro);

        return usuariosRepository.save(usuario);
    }
}