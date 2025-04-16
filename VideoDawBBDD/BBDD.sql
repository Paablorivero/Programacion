DROP DATABASE IF EXISTS VideoDaw;
CREATE DATABASE VideoDaw;
USE VideoDaw;

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
    codCliente INT,
    titulo VARCHAR(20) NOT NULL,
    descripcion VARCHAR(90) NOT NULL,
    fecha_registro DATE NOT NULL,
    fecha_baja DATE NOT NULL,
    CONSTRAINT FOREIGN KEY (codCliente) REFERENCES Cliente (cod)
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

-- Insert data into Persona table
INSERT INTO Persona VALUES ('12345678A', 'Juan Pérez', 'Calle Mayor 23, Madrid', '1985-04-12');
INSERT INTO Persona VALUES ('23456789B', 'María García', 'Avenida Libertad 45, Barcelona', '1990-07-23');
INSERT INTO Persona VALUES ('34567890C', 'Carlos López', 'Plaza España 12, Sevilla', '1978-11-05');
INSERT INTO Persona VALUES ('45678901D', 'Ana Martínez', 'Calle Sol 78, Valencia', '1992-02-18');
INSERT INTO Persona VALUES ('56789012E', 'Pedro Sánchez', 'Paseo Castellana 34, Madrid', '1980-09-30');
INSERT INTO Persona VALUES ('67890123F', 'Laura Fernández', 'Calle Alcalá 56, Madrid', '1995-06-14');
INSERT INTO Persona VALUES ('78901234G', 'Miguel Rodríguez', 'Rambla Catalunya 89, Barcelona', '1983-03-27');
INSERT INTO Persona VALUES ('89012345H', 'Carmen Gómez', 'Calle Sierpes 23, Sevilla', '1975-12-08');
INSERT INTO Persona VALUES ('90123456I', 'Javier Ruiz', 'Avenida Rey 67, Valencia', '1988-08-19');
INSERT INTO Persona VALUES ('01234567J', 'Elena Díaz', 'Calle Gran Vía 12, Madrid', '1993-01-25');
INSERT INTO Persona VALUES ('11223344K', 'Roberto Muñoz', 'Paseo Gracia 45, Barcelona', '1982-05-10');
INSERT INTO Persona VALUES ('22334455L', 'Sara Jiménez', 'Calle Betis 78, Sevilla', '1987-10-21');
INSERT INTO Persona VALUES ('33445566M', 'David Moreno', 'Avenida Puerto 34, Valencia', '1979-07-04');
INSERT INTO Persona VALUES ('44556677N', 'Lucía Álvarez', 'Calle Princesa 90, Madrid', '1991-03-15');
INSERT INTO Persona VALUES ('55667788O', 'Pablo Serrano', 'Paseo Borne 23, Barcelona', '1984-09-28');
INSERT INTO Persona VALUES ('66778899P', 'Sofía Castro', 'Plaza Nueva 56, Sevilla', '1976-11-12');
INSERT INTO Persona VALUES ('77889900Q', 'Alberto Torres', 'Calle Ruzafa 67, Valencia', '1989-04-07');
INSERT INTO Persona VALUES ('88990011R', 'Raquel Ortiz', 'Avenida América 34, Madrid', '1994-08-23');
INSERT INTO Persona VALUES ('99001122S', 'Daniel Blanco', 'Rambla Raval 89, Barcelona', '1981-02-16');
INSERT INTO Persona VALUES ('00112233T', 'Isabel Ramos', 'Calle Feria 12, Sevilla', '1986-06-29');

-- Insert data into Cliente table
INSERT INTO Cliente VALUES (1, '12345678A', '2024-12-31', 3, 5);
INSERT INTO Cliente VALUES (2, '23456789B', '2025-03-15', 2, 3);
INSERT INTO Cliente VALUES (3, '34567890C', '2024-10-20', 5, 7);
INSERT INTO Cliente VALUES (4, '45678901D', '2025-01-05', 1, 2);
INSERT INTO Cliente VALUES (5, '56789012E', '2024-11-30', 4, 6);
INSERT INTO Cliente VALUES (6, '67890123F', '2025-04-10', 0, 1);
INSERT INTO Cliente VALUES (7, '78901234G', '2024-09-25', 2, 4);
INSERT INTO Cliente VALUES (8, '89012345H', '2025-02-18', 3, 5);
INSERT INTO Cliente VALUES (9, '90123456I', '2024-12-05', 1, 3);
INSERT INTO Cliente VALUES (10, '01234567J', '2025-03-28', 2, 4);

-- Insert data into Empleado table
INSERT INTO Empleado VALUES (1, '11223344K', '2020-06-15', 1800.50);
INSERT INTO Empleado VALUES (2, '22334455L', '2018-03-20', 2100.75);
INSERT INTO Empleado VALUES (3, '33445566M', '2019-09-10', 1950.25);
INSERT INTO Empleado VALUES (4, '44556677N', '2021-01-05', 1750.80);
INSERT INTO Empleado VALUES (5, '55667788O', '2017-11-22', 2300.00);
INSERT INTO Empleado VALUES (6, '66778899P', '2022-04-18', 1680.60);
INSERT INTO Empleado VALUES (7, '77889900Q', '2019-07-30', 2050.40);
INSERT INTO Empleado VALUES (8, '88990011R', '2020-10-12', 1900.90);
INSERT INTO Empleado VALUES (9, '99001122S', '2018-05-28', 2200.30);
INSERT INTO Empleado VALUES (10, '00112233T', '2021-08-15', 1850.70);

-- Insert data into Articulo table
INSERT INTO Articulo VALUES (101, 1, 'Avatar', 'Película de ciencia ficción sobre un mundo alienígena', '2023-05-10', '9999-01-01');
INSERT INTO Articulo VALUES (102, 2, 'Minecraft', 'Videojuego de mundo abierto y construcción', '2023-06-22', '9999-01-01');
INSERT INTO Articulo VALUES (103, 3, 'El Padrino', 'Película clásica sobre la mafia siciliana', '2023-04-05', '9999-01-01');
INSERT INTO Articulo VALUES (104, 4, 'FIFA 23', 'Videojuego de fútbol', '2023-07-18', '9999-01-01');
INSERT INTO Articulo VALUES (105, 5, 'Titanic', 'Película romántica sobre el hundimiento del Titanic', '2023-03-15', '9999-01-01');
INSERT INTO Articulo VALUES (106, 6, 'The Witcher 3', 'Videojuego de rol y fantasía', '2023-08-30', '9999-01-01');
INSERT INTO Articulo VALUES (107, 7, 'Interestelar', 'Película de ciencia ficción sobre viajes espaciales', '2023-02-25', '9999-01-01');
INSERT INTO Articulo VALUES (108, 8, 'Tetris', 'Videojuego clásico de puzzle', '2023-09-12', '9999-01-01');
INSERT INTO Articulo VALUES (109, 9, 'El Resplandor', 'Película de terror basada en la novela de Stephen King', '2023-01-20', '9999-01-01');
INSERT INTO Articulo VALUES (110, 10, 'Age of Empires', 'Videojuego de estrategia histórica', '2023-10-05', '9999-01-01');
INSERT INTO Articulo VALUES (111, 1, 'Matrix', 'Película de ciencia ficción sobre realidad virtual', '2023-11-15', '9999-01-01');
INSERT INTO Articulo VALUES (112, 2, 'Call of Duty', 'Videojuego de disparos en primera persona', '2023-12-08', '9999-01-01');
INSERT INTO Articulo VALUES (113, 3, 'Jurassic Park', 'Película de aventuras con dinosaurios', '2024-01-25', '9999-01-01');
INSERT INTO Articulo VALUES (114, 4, 'The Sims 4', 'Videojuego de simulación social', '2024-02-19', '9999-01-01');
INSERT INTO Articulo VALUES (115, 5, 'La La Land', 'Película musical romántica', '2024-03-07', '9999-01-01');
INSERT INTO Articulo VALUES (116, 6, 'Portal 2', 'Videojuego de puzzle y plataformas', '2024-04-22', '9999-01-01');
INSERT INTO Articulo VALUES (117, 7, 'El Rey León', 'Película animada sobre un joven león', '2024-05-18', '9999-01-01');
INSERT INTO Articulo VALUES (118, 8, 'Grand Theft Auto V', 'Videojuego de mundo abierto y acción', '2024-06-30', '9999-01-01');
INSERT INTO Articulo VALUES (119, 9, 'Pulp Fiction', 'Película de culto de Quentin Tarantino', '2024-07-14', '9999-01-01');
INSERT INTO Articulo VALUES (120, 10, 'World of Warcraft', 'Videojuego de rol multijugador masivo', '2024-08-27', '9999-01-01');

-- Insert data into Pelicula table
INSERT INTO Pelicula VALUES (101, 'ACCION', '2024-04-05', TRUE);
INSERT INTO Pelicula VALUES (103, 'DRAMA', '2024-03-20', TRUE);
INSERT INTO Pelicula VALUES (105, 'DRAMA', '2024-04-10', TRUE);
INSERT INTO Pelicula VALUES (107, 'FANTASIA', NULL, FALSE);
INSERT INTO Pelicula VALUES (109, 'TERROR', '2024-04-12', TRUE);
INSERT INTO Pelicula VALUES (111, 'ACCION', NULL, FALSE);
INSERT INTO Pelicula VALUES (113, 'ACCION', '2024-03-25', TRUE);
INSERT INTO Pelicula VALUES (115, 'COMEDIA', NULL, FALSE);
INSERT INTO Pelicula VALUES (117, 'FANTASIA', '2024-04-15', TRUE);
INSERT INTO Pelicula VALUES (119, 'DRAMA', NULL, FALSE);

-- Insert data into VideoJuego table
INSERT INTO VideoJuego VALUES (102, 'SANDBOX', NULL, FALSE);
INSERT INTO VideoJuego VALUES (104, 'SIMULACION', '2024-04-08', TRUE);
INSERT INTO VideoJuego VALUES (106, 'ROL', NULL, FALSE);
INSERT INTO VideoJuego VALUES (108, 'PUZZLE', '2024-03-15', TRUE);
INSERT INTO VideoJuego VALUES (110, 'ESTRATEGIA', '2024-04-14', TRUE);
INSERT INTO VideoJuego VALUES (112, 'SHOOTER', NULL, FALSE);
INSERT INTO VideoJuego VALUES (114, 'SIMULACION', '2024-03-28', TRUE);
INSERT INTO VideoJuego VALUES (116, 'PUZZLE', NULL, FALSE);
INSERT INTO VideoJuego VALUES (118, 'SANDBOX', '2024-04-02', TRUE);
INSERT INTO VideoJuego VALUES (120, 'ROL', NULL, FALSE);

SELECT a.cod, a.titulo, a.descripcion, a.fecha_registro, p.genero, p.alquilada
FROM Articulo a 
JOIN Pelicula p ON p.cod = a.cod
WHERE a.fecha_baja = '9999-01-01';
    
    
SELECT * FROM Pelicula