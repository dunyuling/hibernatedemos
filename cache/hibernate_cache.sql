DROP DATABASE IF EXISTS `hibernate_cache`;
CREATE DATABASE `hibernate_cache` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hibernate_cache`;

#
# Source for table customer
#

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `email` varchar(300) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Dumping data for table customer
#

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'张三','13800000000','中国上海××区××路','13800000000@138.com','男','热爱编程的程序员',25,'1990-01-01');
INSERT INTO `customer` VALUES (2,'李四','13888888888','中国北京××区××路','13888888888@138.com','女','酷爱网购的白领',20,'1995-02-21');
INSERT INTO `customer` VALUES (3,'王五','15888888888','中国深圳××区××路','15888888888@158.com','男','这个家伙很懒，什么也没有留下',35,'1980-04-14');
INSERT INTO `customer` VALUES (4,'赵六','13900000000',NULL,NULL,'男',NULL,40,'1975-01-01');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;