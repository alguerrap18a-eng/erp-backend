package com.erp.backend.controller;

import com.erp.backend.entity.Empresa;
import com.erp.backend.service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> getAll() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {
        return new ResponseEntity<>(empresaService.save(empresa), HttpStatus.CREATED);
    }
}