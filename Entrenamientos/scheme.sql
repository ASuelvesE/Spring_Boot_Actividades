-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: deportes.cjhojoukydxs.us-east-1.rds.amazonaws.com    Database: appdeportes
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Current Database: `appdeportes`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `appdeportes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `appdeportes`;

--
-- Table structure for table `ejercicios`
--

DROP TABLE IF EXISTS `ejercicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejercicios` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `duracion` varchar(100) DEFAULT NULL,
  `resistencia` int unsigned DEFAULT NULL,
  `velocidad` int unsigned DEFAULT NULL,
  `recuperacion` int unsigned DEFAULT NULL,
  `dureza` tinyint unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejercicios`
--

LOCK TABLES `ejercicios` WRITE;
/*!40000 ALTER TABLE `ejercicios` DISABLE KEYS */;
INSERT INTO `ejercicios` VALUES (1,'Push Up','Las flexiones de brazos...','00:03:00',3,1,2,2),(2,'Bench Press','Ejercicio de peso libre...','00:01:00',3,2,3,2),(3,'Sprints','Intervalos cortos','00:01:00',1,3,2,2);
/*!40000 ALTER TABLE `ejercicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenamientos`
--

DROP TABLE IF EXISTS `entrenamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrenamientos` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `durezaMedia` tinyint unsigned DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenamientos`
--

LOCK TABLES `entrenamientos` WRITE;
/*!40000 ALTER TABLE `entrenamientos` DISABLE KEYS */;
INSERT INTO `entrenamientos` VALUES (2,2,'2022-10-25 09:29:13');
/*!40000 ALTER TABLE `entrenamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenamientos_ejercicios`
--

DROP TABLE IF EXISTS `entrenamientos_ejercicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrenamientos_ejercicios` (
  `id_ejercicio` int unsigned NOT NULL,
  `id_entrenamiento` int unsigned NOT NULL,
  PRIMARY KEY (`id_ejercicio`,`id_entrenamiento`),
  KEY `id_entrenamiento` (`id_entrenamiento`),
  CONSTRAINT `entrenamientos_ejercicios_ibfk_1` FOREIGN KEY (`id_ejercicio`) REFERENCES `ejercicios` (`id`),
  CONSTRAINT `entrenamientos_ejercicios_ibfk_2` FOREIGN KEY (`id_entrenamiento`) REFERENCES `entrenamientos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenamientos_ejercicios`
--

LOCK TABLES `entrenamientos_ejercicios` WRITE;
/*!40000 ALTER TABLE `entrenamientos_ejercicios` DISABLE KEYS */;
INSERT INTO `entrenamientos_ejercicios` VALUES (3,2);
/*!40000 ALTER TABLE `entrenamientos_ejercicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiquetas`
--

DROP TABLE IF EXISTS `etiquetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etiquetas` (
  `id_ejercicio` int unsigned NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  PRIMARY KEY (`id_ejercicio`,`descripcion`),
  CONSTRAINT `etiquetas_ibfk_1` FOREIGN KEY (`id_ejercicio`) REFERENCES `ejercicios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiquetas`
--

LOCK TABLES `etiquetas` WRITE;
/*!40000 ALTER TABLE `etiquetas` DISABLE KEYS */;
INSERT INTO `etiquetas` VALUES (2,'Técnica'),(3,'Agilidad');
/*!40000 ALTER TABLE `etiquetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `dni` varchar(20) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellidos` varchar(60) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `resistencia` tinyint unsigned DEFAULT NULL,
  `velocidad` tinyint unsigned DEFAULT NULL,
  `recuperacion` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'18059004W','Angel','Suelves','1991-07-18',3,3,3),(2,'1800000L','Maria','Garcia Salas','1989-10-24',1,3,1);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiales` (
  `id_ejercicio` int unsigned NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  PRIMARY KEY (`id_ejercicio`,`descripcion`),
  CONSTRAINT `materiales_ibfk_1` FOREIGN KEY (`id_ejercicio`) REFERENCES `ejercicios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiales`
--

LOCK TABLES `materiales` WRITE;
/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
INSERT INTO `materiales` VALUES (2,'Banco'),(2,'Barra'),(3,'zapatillas');
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recursosMultimedia`
--

DROP TABLE IF EXISTS `recursosMultimedia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recursosMultimedia` (
  `id_ejercicio` int unsigned NOT NULL,
  `clave` varchar(250) NOT NULL,
  `valor` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_ejercicio`,`clave`),
  CONSTRAINT `recursosMultimedia_ibfk_1` FOREIGN KEY (`id_ejercicio`) REFERENCES `ejercicios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recursosMultimedia`
--

LOCK TABLES `recursosMultimedia` WRITE;
/*!40000 ALTER TABLE `recursosMultimedia` DISABLE KEYS */;
INSERT INTO `recursosMultimedia` VALUES (2,'demostracion','https://www.youtube.com/result'),(3,'demostracion','https://www.youtube.com');
/*!40000 ALTER TABLE `recursosMultimedia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservaEntrenamientos`
--

DROP TABLE IF EXISTS `reservaEntrenamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservaEntrenamientos` (
  `id_jugador` int unsigned NOT NULL,
  `id_entrenamiento` int unsigned NOT NULL,
  PRIMARY KEY (`id_jugador`,`id_entrenamiento`),
  KEY `id_entrenamiento` (`id_entrenamiento`),
  CONSTRAINT `reservaEntrenamientos_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `jugadores` (`id`),
  CONSTRAINT `reservaEntrenamientos_ibfk_2` FOREIGN KEY (`id_entrenamiento`) REFERENCES `entrenamientos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservaEntrenamientos`
--

LOCK TABLES `reservaEntrenamientos` WRITE;
/*!40000 ALTER TABLE `reservaEntrenamientos` DISABLE KEYS */;
INSERT INTO `reservaEntrenamientos` VALUES (1,2),(2,2);
/*!40000 ALTER TABLE `reservaEntrenamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'appdeportes'
--
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-31 19:02:41
