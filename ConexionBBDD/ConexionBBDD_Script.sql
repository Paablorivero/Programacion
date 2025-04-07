DROP DATABASE IF EXISTS conexionbbdd;
CREATE DATABASE conexionbbdd;
USE conexionbbdd;

CREATE TABLE `tipo` (
  `id` INT PRIMARY KEY,
  `nombre` VARCHAR(30) NOT NULL
);

CREATE TABLE `producto` (
  `id` INT PRIMARY KEY,
  `referencia` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `descripcion` VARCHAR(60) NOT NULL,
  `tipo` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` DOUBLE NOT NULL,
  `descuento` INT NULL DEFAULT NULL,
  `iva` INT NULL DEFAULT NULL,
  `aplicarDto` BOOLEAN NOT NULL,
  CONSTRAINT `fk_tipo` FOREIGN KEY (`tipo`) REFERENCES `tipo` (`id`)
  );

INSERT INTO tipo (id, nombre) VALUES 
(1, 'Electrónica'),
(2, 'Ropa'),
(3, 'Hogar'),
(4, 'Deportes'),
(5, 'Juguetes');

INSERT INTO producto (id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto) VALUES 
(1, 'ELEC123', 'Auriculares', 'Auriculares inalámbricos con cancelación de ruido', 1, 50, 89.99, 10, 21, TRUE),
(2, 'ROP456', 'Camiseta', 'Camiseta de algodón orgánico', 2, 200, 15.50, 5, 21, TRUE),
(3, 'HOG789', 'Lámpara LED', 'Lámpara LED de escritorio regulable', 3, 80, 24.99, 0, 21, FALSE),
(4, 'DEP321', 'Balón fútbol', 'Balón de fútbol tamaño oficial', 4, 100, 29.99, 15, 21, TRUE),
(5, 'JUG654', 'Puzzle 1000', 'Puzzle de 1000 piezas paisajes', 5, 60, 18.75, 0, 21, FALSE);
