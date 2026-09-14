package com.erp.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "sucursales")
@Getter
@Setter
public class Sucursales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long id;

    @Column(name = "id_empresa", nullable = false)
    private Long idEmpresa;

    @Column(name = "nombre_sucursal", nullable = false, length = 255)
    private String nombreSucursal;

    @Column(name = "es_matriz")
    private Boolean esMatriz = false;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(name = "email_contacto", length = 100)
    private String emailContacto;

    @Column(length = 150)
    private String calle;

    @Column(name = "numero_exterior", length = 20)
    private String numeroExterior;

    @Column(name = "numero_interior", length = 20)
    private String numeroInterior;

    @Column(length = 100)
    private String colonia;

    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    @Column(name = "ciudad_municipio", length = 100)
    private String ciudadMunicipio;

    @Column(name = "estado_provincia", length = 100)
    private String estadoProvincia;

    @Column(length = 50)
    private String pais = "México";

    private Boolean estado = true;

    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now();
    }
}