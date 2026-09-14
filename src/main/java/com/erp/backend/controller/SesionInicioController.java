package com.erp.backend.controller;

import com.erp.backend.entity.SesionInicio;
import com.erp.backend.service.SesionInicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/sesion-inicio")
public class SesionInicioController {

    private final SesionInicioService sesionInicioService;

    public SesionInicioController(SesionInicioService sesionInicioService) {
        this.sesionInicioService = sesionInicioService;
    }

    @GetMapping
    public List<SesionInicio> getAll() {
        return sesionInicioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SesionInicio> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sesionInicioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SesionInicio> create(@RequestBody SesionInicio sesionInicio) {
        return new ResponseEntity<>(sesionInicioService.save(sesionInicio), HttpStatus.CREATED);
    }
}