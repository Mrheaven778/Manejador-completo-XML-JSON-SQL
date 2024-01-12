CREATE DATABASE IF NOT EXISTS reservas_db;
USE reservas_db;


CREATE TABLE Reservas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    fecha_evento VARCHAR(500),
    tipo_cocina VARCHAR(500),
    n_jornadas VARCHAR(500),
    n_habitaciones VARCHAR(500),
    tipo_mesa VARCHAR(500),
    n_comensales VARCHAR(500)
);

