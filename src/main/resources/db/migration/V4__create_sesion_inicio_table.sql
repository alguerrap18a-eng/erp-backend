CREATE TABLE IF NOT EXISTS sesion_inicio (
                                             id_sesion_inicio INT PRIMARY KEY AUTO_INCREMENT,
                                             id_usuario INT NOT NULL,
                                             token VARCHAR(255),
                                             fecha_inicio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                             fecha_termino TIMESTAMP NULL,
                                             estatus BOOLEAN DEFAULT TRUE,
                                             CONSTRAINT fk_sesion_usuarios
                                                 FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
                                                     ON DELETE CASCADE
);