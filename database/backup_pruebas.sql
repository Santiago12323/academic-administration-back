-- MySQL dump 10.13  Distrib 8.0.42, for Linux (x86_64)
--
-- Host: localhost    Database: gestion_academica
-- ------------------------------------------------------
-- Server version	8.0.42

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

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grades` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `registration_date` datetime(6) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `subject_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK13a16545m7vvrcspc999r15s9` (`student_id`),
  KEY `FKrc0s5tgvm9r4ccxitaqtu88k5` (`subject_id`),
  CONSTRAINT `FK13a16545m7vvrcspc999r15s9` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `FKrc0s5tgvm9r4ccxitaqtu88k5` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` VALUES ('1b16d022-a7df-43a2-a8fd-8bc34ccb31de','TALLER','2026-04-15 15:08:49.317473',4.7,'3b3c9df6-d70a-4b81-96a1-3a16da9bdebc','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('20b93c03-8a3e-45a9-a5de-a2fbcd11ef65','PARCIAL','2026-04-15 15:07:58.297189',4.4,'45de0d1b-b125-49cc-93fd-8c2b0eb408c7','429bbe67-c82f-4a9d-b241-bc4beea4481c'),('31c7f01f-255f-4dce-bd89-923fe3ffbd88','PARRCIAL','2026-04-15 15:09:26.734483',4.8,'45de0d1b-b125-49cc-93fd-8c2b0eb408c7','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('4da791cf-e6c0-4bdc-af78-73e2a474904b','QUIZ','2026-04-15 15:09:47.303436',4.8,'51ceb903-baeb-44de-9510-77f1d8b2d2f5','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('5c88c723-a6f7-4876-9937-de89d0189d4e','QUIZ','2026-04-15 15:09:33.222432',4.8,'45de0d1b-b125-49cc-93fd-8c2b0eb408c7','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('6d104f02-44c9-4fa3-a251-c341d3a5e706','QUIZ','2026-04-15 15:09:17.409319',4.5,'45de0d1b-b125-49cc-93fd-8c2b0eb408c7','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('8981e3b4-7a48-4613-9b02-eb5536e0d605','QUIZ','2026-04-15 15:08:16.885883',4.7,'3b3c9df6-d70a-4b81-96a1-3a16da9bdebc','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('9b1e5371-f521-47fe-a8ff-9bb616f0bcbe','PACIAL','2026-04-15 15:09:03.633247',4.7,'3b3c9df6-d70a-4b81-96a1-3a16da9bdebc','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('c6d5cbdf-574f-4c6a-80db-0de75699834c','LECTURA','2026-04-15 15:10:00.647843',4.8,'51ceb903-baeb-44de-9510-77f1d8b2d2f5','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('edd122f6-339d-47f8-96c8-ed2add3d11a0','PARCIAL','2026-04-15 15:09:41.975120',4.7,'51ceb903-baeb-44de-9510-77f1d8b2d2f5','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('f454ad51-781e-45fc-8ff4-a2192d3b9e63','PARCIAL','2026-04-15 15:08:39.979981',4.6,'3b3c9df6-d70a-4b81-96a1-3a16da9bdebc','0c4c2779-7392-4674-b2b5-e229fe65adbb'),('f816ea6d-0a62-41e8-843b-a5717f7ec089','QUIZ','2026-04-15 15:09:55.061739',4.8,'51ceb903-baeb-44de-9510-77f1d8b2d2f5','0c4c2779-7392-4674-b2b5-e229fe65adbb');
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` varchar(255) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('3b3c9df6-d70a-4b81-96a1-3a16da9bdebc','2002-04-12','jhon@mail.com','jhon','tomalo'),('45de0d1b-b125-49cc-93fd-8c2b0eb408c7','1990-02-12','sara@mail.ecom','sara','torres'),('51ceb903-baeb-44de-9510-77f1d8b2d2f5','2002-04-12','hernesto@mail.com','hernensto','perez'),('790c6663-2710-4a01-8baf-c07bcbae68f9','2001-04-13','felipe@gmail.com','felipe ','camoli'),('a6fca014-a3d1-48d6-a77a-dc908ee6a465','2002-04-15','carlos@gmail.com','carlos','torres'),('f9544c90-f3ca-4496-ab69-7df854d74010','2000-05-12','ana@mail.com','ana ','frnak');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `credits` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES ('0c4c2779-7392-4674-b2b5-e229fe65adbb','AREP',4,'AREP'),('429bbe67-c82f-4a9d-b241-bc4beea4481c','IETI',4,'IETI'),('5a70346d-fdb8-4d67-8e43-3d092ea8a816','ALDA',4,'ALDA'),('8ca61b8d-eb1e-4b4c-b122-46552c12644d','CVEC',4,'Calculo Vectorial'),('a990bed1-5b1f-44bc-900e-4d738fb74540','ARSW',4,'ARSW'),('ab5d6952-5174-4bb9-90a5-2750fa411b89','BGDA',3,'BIG DATA');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-15 15:11:50
