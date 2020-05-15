/*
Navicat MySQL Data Transfer

Source Server         : bank
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-05-15 10:40:39
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '1', '1');
INSERT INTO `admin` VALUES ('123456', 'qwer123456', '张三');

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
INSERT INTO `customer1` VALUES ('6013023412103449287', '张三', '734.50000', '0.00000', '1234561', '11111111111', '111111111111111111', '0', '1');
INSERT INTO `customer1` VALUES ('6210693727724718740', '哈哈哈', '0.00000', '0.00000', '123456', '11111111114', '111111111111111119', '0', '0');
INSERT INTO `customer1` VALUES ('6222921206400275378', '常颖', '1401.00000', '0.00000', '123456', '12312312312', '111111200011111111', '0', '0');

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
INSERT INTO `leavemessage` VALUES ('2020-05-14 22:44:10', '111111111111111111', '123', '1', '无');
INSERT INTO `leavemessage` VALUES ('2020-05-14 22:44:23', '111111200011111111', 'okk', '1', '无');

-- ----------------------------
-- Table structure for `service`
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------
INSERT INTO `service` VALUES ('12', '12', '张三');
