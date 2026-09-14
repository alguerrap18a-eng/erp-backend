CREATE TABLE IF NOT EXISTS sucursales (
                                          id_sucursal INT PRIMARY KEY AUTO_INCREMENT,
                                          id_empresa INT NOT NULL,
                                          nombre_sucursal VARCHAR(255) NOT NULL,
    es_matriz BOOLEAN DEFAULT FALSE,
    telefono VARCHAR(20) NOT NULL,
    email_contacto VARCHAR(100),
    calle VARCHAR(150),
    numero_exterior VARCHAR(20),
    numero_interior VARCHAR(20),
    colonia VARCHAR(100),
    codigo_postal VARCHAR(10),
    ciudad_municipio VARCHAR(100),
    estado_provincia VARCHAR(100),
    pais VARCHAR(50) DEFAULT 'México',
    estado BOOLEAN DEFAULT TRUE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_sucursales_empresas
    FOREIGN KEY (id_empresa) REFERENCES empresas(id_empresa)
    ON DELETE CASCADE
    );