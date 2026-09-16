package com.erp.backend.controller;

import com.erp.backend.entity.Usuarios;
import com.erp.backend.service.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> getAll() {
        return usuariosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getById(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuarios> create(@RequestBody Usuarios usuario) {
        return new ResponseEntity<>(usuariosService.save(usuario), HttpStatus.CREATED);
    }

}