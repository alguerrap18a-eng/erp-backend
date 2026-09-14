package com.erp.backend.controller;

import com.erp.backend.entity.Sucursales;
import com.erp.backend.service.SucursalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/sucursales")
public class SucursalesController {

    private final SucursalesService sucursalesService;

    public SucursalesController(SucursalesService sucursalesService) {
        this.sucursalesService = sucursalesService;
    }

    @GetMapping
    public List<Sucursales> getAll() {
        return sucursalesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursales> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sucursalesService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Sucursales> create(@RequestBody Sucursales sucursal) {
        return new ResponseEntity<>(sucursalesService.save(sucursal), HttpStatus.CREATED);
    }
}