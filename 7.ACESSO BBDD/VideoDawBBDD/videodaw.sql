CREATE DATABASE IF NOT EXISTS VideoDaw;
USE VideoDaw;

CREATE TABLE IF NOT EXISTS Cliente (
    cod INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(10) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    fecha_nacimiento DATE,
    fecha_baja DATE DEFAULT '9999-01-01',
    n_alquiladas INT DEFAULT 0,
    n_articulos INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS Articulo (
    cod INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_registro DATE NOT NULL,
    fecha_baja DATE DEFAULT '9999-01-01',
    tipo ENUM('PELICULA', 'VIDEOJUEGO') NOT NULL,
    alquilada BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS Pelicula(
    cod INT PRIMARY KEY,
    genero ENUM('ACCION', 'COMEDIA', 'DRAMA', 'FANTASIA', 'TERROR', 'DOCUMENTALES') NOT NULL,
    FOREIGN KEY (cod) REFERENCES Articulo(cod)
);

CREATE TABLE IF NOT EXISTS Videojuego (
    cod INT PRIMARY KEY,
    genero ENUM('SANDBOX', 'ESTRATEGIA', 'SHOOTER', 'ROL', 'SIMULACION', 'PUZZLE') NOT NULL,
    FOREIGN KEY (cod) REFERENCES Articulo(cod)
);

CREATE TABLE IF NOT EXISTS Alquiler (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cod_cliente INT NOT NULL,
    cod_articulo INT NOT NULL,
    fecha_alquiler DATE NOT NULL,
    fecha_devolucion DATE DEFAULT NULL,
    FOREIGN KEY (cod_cliente) REFERENCES Cliente(cod),
    FOREIGN KEY (cod_articulo) REFERENCES Articulo(cod)
);