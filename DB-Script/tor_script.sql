/*
SQLyog Community v12.4.0 (64 bit)
MySQL - 5.6.26-log : Database - tor_detction
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tor_detction` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tor_detction`;

/*Table structure for table `ip_address` */

DROP TABLE IF EXISTS `ip_address`;

CREATE TABLE `ip_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ip_address` varchar(255) DEFAULT NULL,
  `port` varchar(255) DEFAULT NULL,
  `is_tor` varchar(255) DEFAULT 'no',
  `hostname` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `ip_address` */

insert  into `ip_address`(`id`,`ip_address`,`port`,`is_tor`,`hostname`,`remarks`) values 
(15,'124.251.324.14','','no','Amardip-PC','Connected via Wifi'),
(16,'184.24.1452.12','','yes','External-Check','Tor Checked'),
(17,'182.142.241.255','','no','Nikhil-PC','Wifi Connected'),
(18,'45.214.52.142','','yes','Tor-Check','Tor Check'),
(19,'42.512.24.362','','yes','Tor-IP','Tor-Ip'),
(20,'103.10.197.50','','yes','Tor-IP','Found Tor IP'),
(21,'45.248.16.135','','no','My-IP','My-Computer'),
(22,'192.168.1.120','','no','ABHIJIT-PC','Home PC'),
(23,'192.168.122.164','','no','Mandar-PC','home PC'),
(24,'182.168.12.120','','no','Shnakar-PC','Laptop'),
(25,'103.10.197.50','','yes','Remote PC','Remote'),
(26,'103.56.207.84','','yes','remote 2','remote ip');

/*Table structure for table `user_table` */

DROP TABLE IF EXISTS `user_table`;

CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_table` */

insert  into `user_table`(`id`,`login`,`password`,`profile`,`first_name`,`last_name`,`contact_number`) values 
(1,'admin','admin','admin',NULL,NULL,NULL),
(2,'user','user','user',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
