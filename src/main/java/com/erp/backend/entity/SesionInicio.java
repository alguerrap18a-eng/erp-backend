package com.erp.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "sesion_inicio")
@Getter
@Setter
public class SesionInicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesion_inicio")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "fecha_inicio", updatable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_termino")
    private LocalDateTime fechaTermino;

    private Boolean estatus = true;

    @PrePersist
    protected void onCreate() {
        this.fechaInicio = LocalDateTime.now();
    }
}