DROP TABLE IF EXISTS `empleados`;
DROP table IF EXISTS departamentos;


CREATE TABLE `departamentos` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `presupuesto` int DEFAULT NULL,
  PRIMARY KEY (`codigo`)
);

CREATE TABLE `empleados` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(8),
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `departamento` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `empleados_fk` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`codigo`)
);


insert into departamentos (nombre,presupuesto)values('Animación', 50000);
insert into departamentos (nombre,presupuesto)values('RRSS', 2000);
insert into departamentos (nombre,presupuesto)values('Dirección',3500);
insert into departamentos (nombre,presupuesto)values('Administración', 60000);
insert into departamentos (nombre,presupuesto)values('Informática', 1000);

insert into empleados (dni, nombre, apellidos, departamento) values ('12345678', 'Josefina', 'Fernández',1);
insert into empleados (dni, nombre, apellidos, departamento) values ('87654321','Elena', 'Hernández',2);
insert into empleados (dni, nombre, apellidos, departamento) values ('46573820','Tomás', 'Gomez',3);
insert into empleados (dni, nombre, apellidos, departamento) values ('65910385','Dante', 'Blanco',5);