/*
Navicat MySQL Data Transfer

Source Server         : bank
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : bank

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-05-10 00:00:25
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
  `balance` double(20,0) DEFAULT NULL,
  `loan` double(20,0) DEFAULT NULL,
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
INSERT INTO `customer1` VALUES ('4367562891930537478', '1321123123', '1321', '1', '1321312', '555', '1', '1', null);
INSERT INTO `customer1` VALUES ('6210621981477998501', '小王', '1200', '9900', '123456', '11111111112', '111111200011111111', '3', null);
INSERT INTO `customer1` VALUES ('6222187185972558428', '1', '0', '0', '1', '1', '1', '0', '0');
INSERT INTO `customer1` VALUES ('6222704642762368398', '1', '0', '0', '1', '1', '1', '0', null);
