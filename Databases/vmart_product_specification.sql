-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vmart
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
-- Table structure for table `product_specification`
--

DROP TABLE IF EXISTS `product_specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_specification` (
  `Product_pid` bigint NOT NULL,
  `specification` varchar(255) DEFAULT NULL,
  KEY `FK4f8ggoisahr7fnnykht2eh7k6` (`Product_pid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_specification`
--

LOCK TABLES `product_specification` WRITE;
/*!40000 ALTER TABLE `product_specification` DISABLE KEYS */;
INSERT INTO `product_specification` VALUES (22,'Fabric: Cotton'),(22,'Fit: Regular Fit'),(22,'Length: Regular'),(22,'Main Trend: Typography or Slogan Prints'),(22,'Multipack Set: Single'),(22,'Neck: Round Neck'),(22,'Occasion: Casual'),(22,'Wash Care: Machine Wash'),(23,'Character: Avengers'),(23,'Fabric: Cotton'),(23,'Fit: Regular Fit'),(23,'Length: Regular'),(23,'Neck: Round Neck'),(23,'Occasion: Casual'),(24,'Fabric: Cotton'),(24,'Fit: Regular Fit'),(24,'Neck: Round Neck'),(24,'Occasion: Casual'),(24,'Wash Care: Machine Wash'),(26,'Fabric: Polyester'),(26,'Fit: Regular Fit'),(26,'Neck: Round Neck'),(26,'Occasion: Casual'),(26,'Wash Care: Machine Wash'),(26,'Pattern: Striped'),(27,'Fabric: Cotton'),(27,'Main Trend: Micro or Ditsy Print'),(27,'Occasion: Casual'),(27,'Neck: Polo Collar'),(27,'Fit: Regular Fit'),(27,'Pattern Coverage: All-Over'),(28,'Fabric:Cotton'),(28,'Fit:Regular Fit'),(28,'Neck:Round Neck'),(28,'Occasion:Casual'),(28,'Print or Pattern Type:Colourblocked'),(29,'Fabric:Cotton'),(29,'Fit:Regular Fit'),(29,'Neck:Round Neck'),(29,'Occasion:Casual'),(29,'Print or Pattern Type:Graphic'),(29,'Wash Care:Machine Wash'),(30,'Fabric:Cotton'),(30,'Fit:Regular Fit'),(30,'Neck:Round Neck'),(30,'Occasion:Casual'),(30,'Print or Pattern Type:Typography'),(30,'Wash Care:Machine Wash'),(31,'Fabric:Cotton'),(31,'Fit:Regular Fit'),(31,'Neck:Round Neck'),(31,'Occasion:Casual'),(31,'Print or Pattern Type:Typography'),(31,'Wash Care:Machine Wash'),(32,'Fabric:Cotton'),(32,'Fit:Regular Fit'),(32,'Neck:Round Neck'),(32,'Occasion:Casual'),(32,'Print or Pattern Type:Typography'),(32,'Wash Care:Machine Wash'),(33,'Type:Shirt Style'),(33,'Transparency:Opaque'),(33,'Neck:Mandarin Collar'),(33,'Fabric Type:Crepe'),(33,'Occasion:Casual'),(34,'Type:Shirt Style'),(34,'Transparency:Opaque'),(34,'Neck:Mandarin Collar'),(34,'Fabric Type:Crepe'),(34,'Occasion:Casual'),(35,'Neck:V-Neck'),(35,'Occasion:Casual'),(35,'Main Trend:Polka Dots'),(35,'Type:Wrap'),(35,'Transparency:Opaque'),(36,'Neck:Mandarin Collar'),(36,'Occasion:Casual'),(36,'Main Trend:Lace Frills Bows and Ruffles'),(36,'Type:Shirt Style'),(36,'Transparency:Opaque'),(37,'Neck:V-Neck'),(37,'Occasion:Casual'),(37,'Main Trend:Wrap'),(37,'Type:Wrap'),(37,'Transparency:Opaque'),(38,'Neck:Round Neck'),(38,'Occasion:Casual'),(38,'Main Trend:New Basics'),(38,'Type:Regular'),(38,'Transparency:Opaque'),(39,'Neck:V-Neck'),(39,'Occasion:Casual'),(39,'Main Trend:New Basics'),(39,'Type:Cinched Waist'),(39,'Transparency:Opaque'),(40,'Neck:Round Neck'),(40,'Occasion:Casual'),(40,'Main Trend:Lace Frills Bows and Ruffles'),(40,'Type:Regular'),(40,'Transparency:Opaque'),(41,'Neck:Mandarin Collar'),(41,'Occasion:Casual'),(41,'Main Trend:Floral'),(41,'Fabric Type:Georgette'),(41,'Transparency:Opaque'),(42,'Neck:Round Neck'),(42,'Occasion:Casual'),(42,'Main Trend:New Basics'),(42,'Fabric Type:Georgette'),(42,'Transparency:Opaque'),(43,'Neck:Round Neck'),(43,'Occasion:Casual'),(43,'Main Trend:Floral'),(43,'Fabric Type:Georgette'),(43,'Transparency:Opaque'),(44,'Neck:V-Neck'),(44,'Occasion:Casual'),(44,'Main Trend:Floral'),(44,'Fabric Type:Georgette'),(44,'Transparency:Opaque'),(45,'Neck:V-Neck'),(45,'Occasion:Casual'),(45,'Main Trend:Floral'),(45,'Fabric Type:Georgette'),(45,'Transparency:Opaque'),(46,'Neck:Shirt Collar'),(46,'Occasion:Casual'),(46,'Main Trend:Floral'),(46,'Fabric Type:Georgette'),(46,'Transparency:Opaque'),(47,'Waist Rise:Mid-Rise'),(47,'Occasion:Casual'),(47,'Main Trend:New Basics'),(47,'Fit:Slim Fit'),(47,'Length:Regular'),(48,'Waist Rise:Mid-Rise'),(48,'Occasion:Casual'),(48,'Main Trend:New Basics'),(48,'Fit:Tapered Fit'),(48,'Length:Cropped'),(49,'Waist Rise:Mid-Rise'),(49,'Occasion:Casual'),(49,'Main Trend:New Basics'),(49,'Fit:Slim Fit'),(49,'Length:Regular'),(50,'Waist Rise:Mid-Rise'),(50,'Occasion:Casual'),(50,'Main Trend:New Basics'),(50,'Fit:Slim Fit'),(50,'Length:Regular'),(51,'Waist Rise:Low-Rise'),(51,'Occasion:Casual'),(51,'Main Trend:New Basics'),(51,'Fit:Slim Fit'),(51,'Length:Regular'),(52,'Occasion:Casual'),(52,'Main Trend:New Basics'),(52,'Length:Regular'),(52,'Waist Rise:Mid-Rise'),(52,'Fit:Slim Fit');
/*!40000 ALTER TABLE `product_specification` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-05 16:40:23
