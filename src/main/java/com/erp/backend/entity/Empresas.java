package com.erp.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "empresas")
@Getter
@Setter
public class Empresas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa") // <-- Aquí estaba el fallo principal
    private Long id;

    @Column(name = "razon_social", nullable = false, length = 255)
    private String razonSocial;

    @Column(name = "nombre_comercial", length = 255)
    private String nombreComercial;

    @Column(nullable = false, unique = true, length = 15)
    private String rfc;

    @Column(name = "regimen_fiscal", length = 100)
    private String regimenFiscal;

    @Column(name = "email_corporativo", length = 100)
    private String emailCorporativo;

    @Column(name = "sitio_web", length = 150)
    private String sitioWeb;

    @Column(name = "ruta_logo", length = 255)
    private String rutaLogo;

    @Column(name = "moneda_base", length = 10)
    private String monedaBase;

    @Column(name = "repre_legal", length = 150)
    private String repreLegal;

    private Boolean estado;

    @Column(name = "fecha_registro", updatable = false) // <-- Coincide con el SQL
    private LocalDateTime createdAt;

    @Column(name = "ultima_actualizacion") // <-- Coincide con el SQL
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}