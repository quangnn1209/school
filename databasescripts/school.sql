/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : school

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2015-01-20 10:59:12
*/

DROP DATABASE IF EXISTS `school`;
CREATE DATABASE `school`;
USE `school`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ts_id` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '1', 'class1', '2015-01-06 17:25:27', '2015-01-07 17:25:32');
INSERT INTO `class` VALUES ('2', '1', 'abcde', '2015-01-22 11:30:00', '2015-01-22 15:00:00');
INSERT INTO `class` VALUES ('3', '1', '123', '2015-01-23 12:30:00', '2015-01-23 15:00:00');
INSERT INTO `class` VALUES ('4', '1', 'alo', '2015-01-20 08:30:00', '2015-01-20 19:30:00');
INSERT INTO `class` VALUES ('5', '1', 'hihi', '2015-01-21 09:30:00', '2015-01-21 13:30:00');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ts_id` int(11) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('2', '1', '2015-01-26 17:25:04', '2015-01-27 17:25:07', 'exam2');

-- ----------------------------
-- Table structure for timetable_schedule
-- ----------------------------
DROP TABLE IF EXISTS `timetable_schedule`;
CREATE TABLE `timetable_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of timetable_schedule
-- ----------------------------
INSERT INTO `timetable_schedule` VALUES ('1', 'ts2');
INSERT INTO `timetable_schedule` VALUES ('2', 'ts1');
INSERT INTO `timetable_schedule` VALUES ('3', 'ts3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `role` tinyint(4) NOT NULL DEFAULT '0',
  `code` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'quang', '1', 'cde', 'altimario@openprj.it', '5f4dcc3b5aa765d61d8327deb882cf99');
INSERT INTO `user` VALUES ('2', 'quang2', '1', 'code2', 'quang', '2b10351253eed030812674e8aa18a5ab');
