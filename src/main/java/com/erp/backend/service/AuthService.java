package com.erp.backend.service;

import com.erp.backend.entity.SesionInicio;
import com.erp.backend.entity.Usuarios;
import com.erp.backend.repository.SesionInicioRepository;
import com.erp.backend.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private SesionInicioRepository sesionInicioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // <-- Esto era lo que faltaba inyectar

    public String autenticar(String username, String password) {
        // 1. Buscar al usuario por su username
        Optional<Usuarios> usuarioOpt = usuariosRepository.findByUsername(username);

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Usuarios usuario = usuarioOpt.get();

        // 2. Validar contraseña usando BCrypt matches
        if (!passwordEncoder.matches(password, usuario.getPasswordHash())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // 3. Registrar el inicio de sesión en la tabla sesion_inicio
        SesionInicio sesion = new SesionInicio();
        sesion.setIdUsuario(usuario.getId());
        sesion.setFechaInicio(LocalDateTime.now());
        sesion.setToken("TOKEN_EJEMPLO_TEMP");
        sesionInicioRepository.save(sesion);

        return "Login exitoso para el usuario: " + usuario.getNombre();
    }
}