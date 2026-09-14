CREATE TABLE IF NOT EXISTS empresas (
                                        id_empresa INT PRIMARY KEY AUTO_INCREMENT,
                                        razon_social VARCHAR(255) NOT NULL,
    nombre_comercial VARCHAR(255) NOT NULL,
    rfc VARCHAR(15) UNIQUE NOT NULL,
    regimen_fiscal VARCHAR(100),
    email_corporativo VARCHAR(100),
    sitio_web VARCHAR(150),
    ruta_logo VARCHAR(255),
    moneda_base VARCHAR(10) DEFAULT 'MXN',
    repre_legal VARCHAR(150),
    estado BOOLEAN DEFAULT TRUE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ultima_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );