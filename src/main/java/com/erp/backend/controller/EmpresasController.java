package com.erp.backend.controller;

import com.erp.backend.entity.Empresas;
import com.erp.backend.service.EmpresasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sucursales")
public class EmpresasController {

    private final EmpresasService empresaService;

    public EmpresasController(EmpresasService empresasService) {
        this.empresaService = empresasService;
    }

    @GetMapping
    public List<Empresas> getAll() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresas> getById(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Empresas> create(@RequestBody Empresas empresa) {
        return new ResponseEntity<>(empresaService.save(empresa), HttpStatus.CREATED);
    }
}