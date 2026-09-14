CREATE TABLE IF NOT EXISTS usuarios (
                                        id_usuario INT PRIMARY KEY AUTO_INCREMENT,
                                        id_sucursal INT NOT NULL,
                                        nombre VARCHAR(200) NOT NULL,
    username VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(500) NOT NULL,
    email VARCHAR(200),
    estado BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    rol VARCHAR(200) NOT NULL,
    CONSTRAINT fk_usuarios_sucursales
    FOREIGN KEY (id_sucursal) REFERENCES sucursales(id_sucursal)
    ON DELETE CASCADE
    );