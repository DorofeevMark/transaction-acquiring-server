-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: TransactionAcquiring
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `card_info`
--

DROP TABLE IF EXISTS `card_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card_info` (
  `bin` varchar(255) NOT NULL,
  `cardholder_name` varchar(255) DEFAULT NULL,
  `cvv` varchar(255) DEFAULT NULL,
  `expiration_month` varchar(255) DEFAULT NULL,
  `expiration_year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_info`
--

LOCK TABLES `card_info` WRITE;
/*!40000 ALTER TABLE `card_info` DISABLE KEYS */;
INSERT INTO `card_info` VALUES ('2100000000000000','Mark Mark','123','12','21'),('2100000000000002','Mark Mark','123','12','21'),('4100000000000002','Mark Mark','123','12','21'),('4112312312323','KKKK','123','32','32'),('4112312323232','ASKdkasd','123','12','32'),('4123232323232','Mark','123','12','32'),('4131232323323','Mark','123','12','21');
/*!40000 ALTER TABLE `card_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (51);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_info`
--

DROP TABLE IF EXISTS `payment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_info` (
  `id` int NOT NULL,
  `amount` int NOT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `merchant_id` varchar(255) DEFAULT NULL,
  `card_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeulkmqi74i34amegbt4cox319` (`card_id`),
  CONSTRAINT `FKeulkmqi74i34amegbt4cox319` FOREIGN KEY (`card_id`) REFERENCES `card_info` (`bin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_info`
--

LOCK TABLES `payment_info` WRITE;
/*!40000 ALTER TABLE `payment_info` DISABLE KEYS */;
INSERT INTO `payment_info` VALUES (3,123,'USD','id123','2100000000000000'),(5,123,'USD','id123','2100000000000000'),(7,123,'USD','id123','2100000000000000'),(9,123,'USD','id123','2100000000000002'),(11,123,'USD','id123','2100000000000002'),(13,123,'USD','id123','4100000000000002'),(15,123,'USD','id123','4100000000000002'),(17,123,'USD','id123','2100000000000002'),(19,123,'USD','id123','2100000000000002'),(21,123,'USD','id123','2100000000000002'),(23,123,'USD','id123','2100000000000002'),(25,123,'USD','id123','2100000000000002'),(27,123,'USD','id123','2100000000000002'),(29,123,'USD','id123','2100000000000002'),(31,123,'USD','id123','2100000000000002'),(33,123,'USD','id123','2100000000000002'),(35,123,'USD','id123','2100000000000002'),(37,123,'USD','id123','2100000000000002'),(39,123,'USD','id123','2100000000000002'),(41,123,'USD','id123','2100000000000002'),(43,1,'USD','123123','4131232323323'),(45,1,'USD','23123123123','4112312323232'),(47,12222,'USD','skskskksks','4123232323232'),(49,12,'USD','skdakasdksd','4112312312323');
/*!40000 ALTER TABLE `payment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_system`
--

DROP TABLE IF EXISTS `payment_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_system` (
  `id` int NOT NULL,
  `patter` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `endpoint` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_system`
--

LOCK TABLES `payment_system` WRITE;
/*!40000 ALTER TABLE `payment_system` DISABLE KEYS */;
INSERT INTO `payment_system` VALUES (1,'^2[0-9]{15}$','Mir','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment'),(2,'^(5018|5020|5038|6304|6759|6761|6763)[0-9]{8,15}$','Maestro','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment'),(3,'^(5[1-5][0-9]{14}|2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))$','Mastercard','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment'),(4,'^4[0-9]{12}(?:[0-9]{3})?$','Visa','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment'),(5,'^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$','Visa Master','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment'),(6,'^(62[0-9]{14,17})$','Union Pay','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment');
/*!40000 ALTER TABLE `payment_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_log`
--

DROP TABLE IF EXISTS `transaction_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_log` (
  `id` int NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `response` varchar(255) DEFAULT NULL,
  `payment_id` int DEFAULT NULL,
  `payment_system_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4v20cj0aa9ejieixtweq8qvo1` (`payment_id`),
  KEY `FKnqjyck1xnfgh77wccg2l3bck6` (`payment_system_id`),
  CONSTRAINT `FK4v20cj0aa9ejieixtweq8qvo1` FOREIGN KEY (`payment_id`) REFERENCES `payment_info` (`id`),
  CONSTRAINT `FKnqjyck1xnfgh77wccg2l3bck6` FOREIGN KEY (`payment_system_id`) REFERENCES `payment_system` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_log`
--

LOCK TABLES `transaction_log` WRITE;
/*!40000 ALTER TABLE `transaction_log` DISABLE KEYS */;
INSERT INTO `transaction_log` VALUES (8,'2020-03-15 21:46:59.854000','{\n    \"success\": true\n}',7,NULL),(10,'2020-03-15 21:47:19.143000','{\n    \"success\": true\n}',9,NULL),(12,'2020-03-15 22:09:10.314000','{\n    \"success\": true\n}',11,NULL),(14,'2020-03-15 22:09:19.491000','{\n    \"success\": true\n}',13,NULL),(16,'2020-03-15 22:13:14.041000','{\n    \"success\": true\n}',15,4),(18,'2020-03-15 22:13:38.360000','{\n    \"success\": true\n}',17,1),(20,'2020-03-16 13:49:52.958000','{\n    \"success\": true\n}',19,1),(22,'2020-03-16 13:55:13.430000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',21,1),(24,'2020-03-16 13:57:21.164000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',23,1),(26,'2020-03-16 13:58:12.166000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',25,1),(28,'2020-03-16 13:59:10.522000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',27,1),(30,'2020-03-16 14:01:05.575000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',29,1),(32,'2020-03-16 14:03:35.368000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',31,1),(34,'2020-03-16 14:07:11.501000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',33,1),(36,'2020-03-16 14:08:32.529000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',35,1),(38,'2020-03-16 14:10:19.366000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',37,1),(40,'2020-03-16 14:11:16.196000','https://21961397-6985-42ce-8cdc-246853882396.mock.pstmn.io/payment',39,1),(42,'2020-03-16 14:13:04.368000','{\n    \"success\": true\n}',41,1),(44,'2020-04-04 21:55:01.266000','{\n    \"success\": true\n}',43,4),(46,'2020-04-04 21:59:43.494000','{\n    \"success\": true\n}',45,4),(48,'2020-04-05 09:17:47.537000','{\n    \"success\": true\n}',47,4),(50,'2020-04-05 13:32:52.976000','{\n    \"success\": true\n}',49,4);
/*!40000 ALTER TABLE `transaction_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-05 16:45:02
