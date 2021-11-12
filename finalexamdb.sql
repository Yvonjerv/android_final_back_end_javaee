/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : finalexamdb

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2021-06-30 14:20:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_contact`
-- ----------------------------
DROP TABLE IF EXISTS `t_contact`;
CREATE TABLE `t_contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userA` varchar(255) NOT NULL,
  `userB` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_contact
-- ----------------------------
INSERT INTO `t_contact` VALUES ('1', 'home.com', 'holy.com');
INSERT INTO `t_contact` VALUES ('2', 'home.com', 'car.com');

-- ----------------------------
-- Table structure for `t_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `overview` varchar(1000) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('1', 'title', 'details', '32476575699.jpg', 'home.com', '2021-06-14 15:14:23');
INSERT INTO `t_news` VALUES ('2', 'title', 'details', '32476575699.jpg', 'home.com', '2021-06-20 19:24:04');
INSERT INTO `t_news` VALUES ('3', 'titlesasadasdasdas', 'detailsasdasdad', '32476575699.jpg', 'home.com', '2021-06-20 19:24:49');
INSERT INTO `t_news` VALUES ('4', 'titlekjkjkjk', 'detailsjkjkjkjkjkjkj', '32476575699.jpg', 'home.com', '2021-06-20 21:15:11');
INSERT INTO `t_news` VALUES ('5', '12122121212title', '21221212121details', '32476575699.jpg', 'home.com', '2021-06-20 21:20:21');
INSERT INTO `t_news` VALUES ('6', 'qrrttteetitle', 'qwrrwrwdetails', '32476575699.jpg', 'car.com', '2021-06-20 21:22:31');
INSERT INTO `t_news` VALUES ('7', '2221221title', 'dsfgfhgff', '32476575699.jpg', 'car.com', '2021-06-20 21:29:44');
INSERT INTO `t_news` VALUES ('8', 'Lorem ipsum', 'dolor sit, amet consectetur adipisicing elit. Deleniti, dolor numquam quod laborum praesentium explicabo doloremque obcaecati eum vel excepturi!', 'latestdd.png', 'home.com', '2021-06-29 12:42:14');
INSERT INTO `t_news` VALUES ('9', 'latestdd', 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Deleniti, dolor numquam quod laborum praesentium explicabo doloremque obcaecati eum vel excepturi!', 'latestdd.png', 'home.com', '2021-06-29 12:42:16');

-- ----------------------------
-- Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', 'home.com', '1234', 'hakk lili', '76543212t', '32476575699.jpg', 'male');
INSERT INTO `t_users` VALUES ('2', 'holy.com', '1234', 'holy jolie', '123456448484', '32476575699.jpg', 'male');
INSERT INTO `t_users` VALUES ('3', 'car.com', '1234', 'happy happy', '667767676', '32476575699.jpg', 'female');
INSERT INTO `t_users` VALUES ('4', 'yves.com', '1234', 'yves yves', '12409393922', '12409393922.png', 'male');
