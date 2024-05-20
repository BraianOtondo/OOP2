CREATE DATABASE  IF NOT EXISTS `bd-hibernate-uno-a-muchos-tp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd-hibernate-uno-a-muchos-tp`;
DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  `baja` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`idCliente`)
);

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo` (
  `idPrestamo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `monto` double NOT NULL,
  `interes` double NOT NULL,
  `cantCuotas` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  KEY `fkCliente_idx` (`idCliente`),
  CONSTRAINT `fkCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE `cuota` (
  `idCuota` int(11) NOT NULL AUTO_INCREMENT,
  `nroCuota` int(11) NOT NULL,
  `fechaDeVencimiento` date NOT NULL,
  `saldoPendiente` double NOT NULL,
  `amortizacion` double NOT NULL,
  `interesCuota` double NOT NULL,
  `cuota` double NOT NULL,
  `deuda` double NOT NULL,
  `cancelada` boolean not null,
  `fechaDePago` date not null,
  `punitorios` double not null,
  `idPrestamo` int(11) NOT NULL,
  PRIMARY KEY (`idCuota`),
  KEY `fkPrestamo` (`idPrestamo`),
  CONSTRAINT `fkPrestamo1` FOREIGN KEY (`idPrestamo`) REFERENCES `prestamo` (`idPrestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION
);