-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: dd_store
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `pro_id` int NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `brand_id` int NOT NULL,
  `categories_id` int NOT NULL,
  `pro_price` mediumtext NOT NULL,
  `pro_detail` text NOT NULL,
  `pro_code` varchar(50) NOT NULL,
  `pro_quantity` int NOT NULL,
  `pro_image` varchar(255) NOT NULL,
  `pro_datecrate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pro_datemodify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pro_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`pro_id`),
  KEY `brand_id` (`brand_id`),
  KEY `categories_id` (`categories_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`bra_id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`ctg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Laptop Dell Gaming G15 5515',1,1,'24990000','note','G15 5515',10,'https://cdn.tgdd.vn/Products/Images/44/231250/grey-1-org.jpg','2022-06-20 14:18:54','2022-06-20 14:18:54',0),(2,'Laptop Apple MacBook Air M10',3,1,'28990000','note','M1',10,'https://cdn.tgdd.vn/Products/Images/44/231250/grey-1-org.jpg','2022-06-20 14:18:55','2022-06-20 14:18:55',0),(3,'Laptop Asus TUF Gaming FX516PM',2,1,'29690000','note','FX516PM',10,'https://cdn.tgdd.vn/Products/Images/44/231250/grey-1-org.jpg','2022-06-20 14:18:55','2022-06-20 14:18:55',0),(4,'Laptop Apple MacBook Air M11',1,1,'28990000','note','M1',10,'https://cdn.tgdd.vn/Products/Images/44/231250/grey-1-org.jpg','2022-06-20 14:18:56','2022-06-22 11:48:09',0),(5,'dsad',1,1,'1600000','asdsad','20',2055,'asdsa','2022-06-21 15:58:48','2022-06-21 15:58:54',1),(6,'Laptop Apple MacBook Air M11',3,1,'16000000','Lap top Dell Mạnh Mẽ','MB1',20,'https://cdn.tgdd.vn/Products/Images/44/231250/grey-1-org.jpg','2022-06-22 11:50:46','2022-06-22 11:50:46',0),(7,'Laptop Apple MacBook Air M111',1,1,'16000000','Lap top Dell Mạnh Mẽ','MB11',500,'https://cdn.tgdd.vn/Products/Images/44/231250/grey-1-org.jpg','2022-06-22 11:51:19','2022-06-22 12:55:13',0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-22 19:26:26
