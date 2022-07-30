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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `acc_id` int NOT NULL AUTO_INCREMENT,
  `acc_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `acc_phone` int NOT NULL,
  `acc_email` varchar(50) NOT NULL,
  `acc_street` varchar(50) NOT NULL,
  `acc_city` varchar(50) NOT NULL,
  `acc_password` varchar(255) NOT NULL,
  `acc_role` varchar(50) NOT NULL,
  `acc_enabled` tinyint(1) DEFAULT '1',
  `acc_datecrate` datetime DEFAULT CURRENT_TIMESTAMP,
  `acc_datemodify` datetime DEFAULT CURRENT_TIMESTAMP,
  `acc_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`acc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'admin',825421124,'di@gmail.com','Ca Mau','Tp. Ca Mau','$2a$12$z6a2G.8JLxCHmYxXsGAAAeGfbdRYSgQDtcC5P9Rxr9J8pZFOFp5Ay','ROLE_ADMIN',1,NULL,'2022-06-22 12:27:33',0),(2,'user',825421124,'di@gmail.com','Ca Mau','Tp. Ca Mau','$2a$12$.5Fk9JTPQTJqrpOF0yAiLeLAS98ponYL9poAAGUoguSij2ocXXN8q','ROLE_USER',1,'2022-06-20 14:18:53','2022-06-22 12:28:02',0),(3,'user1',825421124,'di@gmail.com','Ca Mau','Tp. Ca Mau','$2a$12$mtlmQmkaPMeiiMVW.VHtueLQf5WNVS0KR2fRqFZXQWJbDW7gdugSy','ROLE_USER',1,'2022-06-20 14:18:53','2022-06-22 12:28:17',0),(4,'user2',825421124,'di@gmail.com','Ca Mau','Tp. Ca Mau','$2a$12$f24XoN1D243vN76Sg0USp.gTY1Hy8MIIW6SCZ9YYU4b2WmFkfYtQS','ROLE_USER',1,NULL,'2022-06-22 12:28:25',0),(5,'user3',825421124,'di@gmail.com','Cà Mau','Tp. Ca Mau','$2a$12$Yb2EG3jTFQCEmnVZwRg2ZehZXpQFRS/qGP6Ze7T81AK6L6GXDFVDO','ROLE_USER',1,'2022-06-22 12:29:06','2022-06-22 13:55:36',0),(6,'Dy Lam',985663662,'lvdi@gmail.com','Kien Giang','Kien Giang','$2a$12$IXuOVxnYfrlpno591Qigx.F5MIuXfBd0vv4UTBuFWjggp465yZsGS','ROLE_USER',1,'2022-06-22 12:37:59','2022-06-22 12:49:06',1),(7,'user33',825421124,'di@gmail.com','Ca Mau','Tp. Ca Mau','$2a$12$/2jSQZ3NAwK1811KCjUaQ.HEl5iQ5AdhdAKkK6x6nj/zhwzMdOyh6','ROLE_USER',1,'2022-06-22 12:42:48','2022-06-22 12:43:45',1),(8,'DyLam1',985663662,'lvdi@gmail.com','Kien Giang','Kien Giang','$2a$12$8WSpEkNCa3AKhxx2wnx71OyVlEjjD5XNqnhhyWbbpU347Py6o6g5q','ROLE_USER',1,NULL,NULL,0),(9,'DyLam2',985663662,'lvdi@gmail.com','Kien Giang','Kien Giang','$2a$12$e0xtCUhMYnjm5vEuQ4yFkuSg3F1Q3F.ZW29FzCTtbaiBWNP2D/pL2','ROLE_USER',1,'2022-06-22 14:55:43','2022-06-22 14:55:43',0),(10,'Disd',123456789,'lvdi.0223@vitenet.net','3/2, Tp. Rach Gia','Kiên Giang','$2a$12$dAfkLMNDNCOArUdc17YkfuhebnFilj2/3Zud/7r4e7J6nSaaRm.ee','ROLE_USER',1,'2022-06-22 16:22:28','2022-06-22 19:21:37',0);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-22 19:26:27
