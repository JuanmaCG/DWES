# DWES
Creacion bbdd

CREATE TABLE `empleados` (
  `nombre` varchar(255) DEFAULT NULL,
  `dni` varchar(255) NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `categoria` int(2) DEFAULT NULL,
  `anyos` int(2) DEFAULT NULL,
  PRIMARY KEY (`dni`)
)

CREATE TABLE `nominas` (
  `salario` int(10) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL primary key references empleados(dni)
)
