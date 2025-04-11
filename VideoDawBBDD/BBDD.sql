DROP DATABASE IF EXISTS VideoDaw;
CREATE DATABASE VideoDaw;
USE VideoDaw;

CREATE TABLE Franquicia (
	id INT PRIMARY KEY,
    cif CHAR(9) NOT NULL,
    direccion VARCHAR(40) NOT NULL,
    fecha_alta DATE NOT NULL
);

CREATE TABLE Persona(
	dni CHAR(9) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(40) NOT NULL,
    nacimiento DATE NOT NULL
);

CREATE TABLE Cliente(
	cod INT PRIMARY KEY,
    dni CHAR(9)  NOT NULL,
    fecha_baja DATE NOT NULL,
    n_alquiladas INT NOT NULL,
    n_articulos INT NOT NULL,
    CONSTRAINT FOREIGN KEY (dni) REFERENCES Persona (dni)
);

CREATE TABLE Empleado(
	cod INT PRIMARY KEY,
    dni CHAR(9) NOT NULL,
    fecha_contrato DATE NOT NULL,
	sueldo DOUBLE NOT NULL,
    CONSTRAINT FOREIGN KEY (dni) REFERENCES Persona (dni)
);

CREATE TABLE Articulo(
	cod INT PRIMARY KEY,
    franquicia INT NOT NULL,
    cliente INT,
    titulo VARCHAR(20) NOT NULL,
    fecha_registro DATE NOT NULL,
    fecha_baja DATE NOT NULL,
    CONSTRAINT FOREIGN KEY (cliente) REFERENCES Cliente (cod),
    CONSTRAINT FOREIGN KEY (franquicia) REFERENCES Franquicia (id)
);

CREATE TABLE Pelicula(
	cod INT PRIMARY KEY,
	genero ENUM('ACCION', 'COMEDIA', 'DRAMA', 'FANTASIA', 'TERROR', 'DOCUMENTALES'),
    fecha_alquiler DATE,
    alquilada BOOLEAN NOT NULL,
    CONSTRAINT FOREIGN KEY (cod) REFERENCES Articulo (cod)
);

CREATE TABLE VideoJuego(
	cod INT PRIMARY KEY,
	genero ENUM('SANDBOX', 'ESTRATEGIA', 'SHOOTER', 'ROL', 'SIMULACION', 'PUZZLE'),
    fecha_alquiler DATE,
    alquilada BOOLEAN NOT NULL,
    CONSTRAINT FOREIGN KEY (cod) REFERENCES Articulo (cod)
);
    