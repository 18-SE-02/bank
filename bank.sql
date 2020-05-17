/*
Navicat MySQL Data Transfer

Source Server         : bank
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-05-16 14:10:01
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `idNum` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '1', '1', '');
INSERT INTO `admin` VALUES ('123456', 'qwer123456', '张三', '');
INSERT INTO `admin` VALUES ('284641', '12', '啊', '111111111111114322');
INSERT INTO `admin` VALUES ('611256', '11312312', '哈哈哈', '111111111111111122');
INSERT INTO `admin` VALUES ('619931', '123456123', '好好', '111111111111110000');

-- ----------------------------
-- Table structure for `customer1`
-- ----------------------------
DROP TABLE IF EXISTS `customer1`;
CREATE TABLE `customer1` (
  `cardNumber` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `balance` double(20,5) DEFAULT NULL,
  `loan` double(20,5) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `idNumber` varchar(20) NOT NULL,
  `type` int(20) DEFAULT NULL,
  `onlineBanking` int(20) DEFAULT NULL,
  PRIMARY KEY (`cardNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer1
-- ----------------------------
INSERT INTO `customer1` VALUES ('1', '1', '312.00000', '123.00000', '121', '1', '1', '3', '0');
INSERT INTO `customer1` VALUES ('4563506968233243423', '略略略', '0.00000', '0.00000', '1209091', '13000000000', '320000200002020000', '0', '0');
INSERT INTO `customer1` VALUES ('6013703282326957157', '长', '0.00000', '0.00000', '123455', '13131313131', '000000200002222222', '0', '0');
INSERT INTO `customer1` VALUES ('6210693727724718740', '哈哈哈', '10.00000', '111.00000', '123456', '11111111114', '111111111111111119', '2', '1');
INSERT INTO `customer1` VALUES ('6222921206400275378', '常颖', '1524.00000', '0.00000', '1234561', '12312312312', '111111200011111111', '0', '1');

-- ----------------------------
-- Table structure for `leavemessage`
-- ----------------------------
DROP TABLE IF EXISTS `leavemessage`;
CREATE TABLE `leavemessage` (
  `date` varchar(20) NOT NULL,
  `idNum` varchar(20) NOT NULL,
  `message` text NOT NULL,
  `look` int(20) NOT NULL,
  `reply` text NOT NULL,
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leavemessage
-- ----------------------------
INSERT INTO `leavemessage` VALUES ('2020-05-14 22:26:53', '111111111111111111', '我觉得可！', '1', '谢谢您的肯定，我们会继续努力的！');
INSERT INTO `leavemessage` VALUES ('2020-05-14 22:44:10', '111111111111111111', '123', '1', '好的好的');
INSERT INTO `leavemessage` VALUES ('2020-05-14 22:44:23', '111111200011111111', 'okk', '1', '无');
INSERT INTO `leavemessage` VALUES ('2020-05-15 23:00:10', '111111111111111119', 'emmmm', '0', '无');
INSERT INTO `leavemessage` VALUES ('2020-05-15 23:02:46', '111111111111111119', '1234', '0', '无');

-- ----------------------------
-- Table structure for `master`
-- ----------------------------
DROP TABLE IF EXISTS `master`;
CREATE TABLE `master` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `idNumber` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master
-- ----------------------------
INSERT INTO `master` VALUES ('123', '123', '123', '');

-- ----------------------------
-- Table structure for `service`
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `idNum` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------
INSERT INTO `service` VALUES ('12', '12', '张三', '');
INSERT INTO `service` VALUES ('853128', '12123', '好', '111111111111111111');
