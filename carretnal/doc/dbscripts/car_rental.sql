/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : car_rental

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 05/04/2021 12:15:07 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `car_info`
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆id',
  `vin` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '车架号',
  `model_id` int(11) DEFAULT NULL COMMENT '车型id',
  `status` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆状态',
  `remark` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `sts` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '状态 A生效 C失效',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_vin` (`vin`) USING BTREE,
  KEY `idx_model_id` (`model_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='车辆信息';

-- ----------------------------
--  Records of `car_info`
-- ----------------------------
BEGIN;
INSERT INTO `car_info` VALUES ('6', '0001', '2', 'A', 'camery', 'A', '2021-05-04 12:12:48', '1', '2021-05-04 12:14:01', null), ('7', '0002', '3', 'A', 'bmw 650', 'A', '2021-05-04 12:13:48', '1', '2021-05-04 12:14:06', null);
COMMIT;

-- ----------------------------
--  Table structure for `car_model`
-- ----------------------------
DROP TABLE IF EXISTS `car_model`;
CREATE TABLE `car_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车型id',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '车型名称',
  `type` varchar(8) CHARACTER SET utf8 DEFAULT NULL COMMENT '车辆品类，A紧凑5座 B舒适5座 C豪华五座 D越野车 E商务车',
  `picture_url` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片url',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `detail` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '详情',
  `sts` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '状态 A生效 C失效',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`) USING BTREE,
  KEY `idx_type` (`type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='车型信息';

-- ----------------------------
--  Records of `car_model`
-- ----------------------------
BEGIN;
INSERT INTO `car_model` VALUES ('1', '丰田卡罗拉', 'A', null, '100', '丰田卡罗拉', 'A', '2021-05-02 01:54:32', '0', '2021-05-02 09:08:24', '0'), ('2', 'Toyota camery', 'B', null, '150', 'Toyota camry', 'A', '2021-05-02 01:56:36', '0', '2021-05-03 19:56:23', '0'), ('3', 'BMW 650', 'C', null, '200', 'BMW 650', 'A', '2021-05-02 01:56:36', '0', '2021-05-03 16:01:45', '0'), ('4', 'jeep大切诺基', 'D', null, '200', 'jeep大切诺基', 'A', '2021-05-02 01:56:36', '0', '2021-05-02 09:08:33', '0'), ('5', '别克GL8', 'E', null, '250', '别克GL8', 'A', '2021-05-02 01:56:36', '0', '2021-05-02 09:08:37', '0');
COMMIT;

-- ----------------------------
--  Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆id',
  `order_no` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '车架号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `car_id` int(11) DEFAULT NULL COMMENT '车辆id',
  `model_id` int(11) DEFAULT NULL COMMENT '车型id',
  `price` decimal(10,0) DEFAULT NULL COMMENT '订单成交价格',
  `start_time` int(11) DEFAULT NULL COMMENT '开始时间',
  `end_time` int(11) DEFAULT NULL COMMENT '结束时间',
  `status` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '订单状态',
  `remark` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `sts` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '状态 A生效 C失效',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_order_no` (`order_no`) USING BTREE,
  KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='车辆信息';

-- ----------------------------
--  Records of `order_info`
-- ----------------------------
BEGIN;
INSERT INTO `order_info` VALUES ('8', '202105031742042995306', '6', null, '2', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-03 17:42:07', '6', '2021-05-03 17:42:07', null), ('9', '202105031751083637121', '6', null, '2', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-03 17:51:21', '6', '2021-05-03 17:51:21', null), ('10', '202105031812320853222', '6', null, '3', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-03 18:12:32', '6', '2021-05-03 18:12:32', null), ('11', '202105031900107083652', '6', null, '3', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-03 19:00:10', '6', '2021-05-03 19:00:10', null), ('12', '202105031900107708733', '6', null, '3', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-03 19:00:10', '6', '2021-05-03 19:00:10', null), ('13', '202105031900107988733', '6', null, '3', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-03 19:00:10', '6', '2021-05-03 19:00:10', null), ('14', '202105031900108238733', '6', null, '3', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-03 19:00:10', '6', '2021-05-03 19:00:10', null), ('15', '202105031900108578733', '6', null, '3', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-03 19:00:10', '6', '2021-05-03 19:00:10', null), ('16', '202105031913358201040', '6', null, '2', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-03 19:13:35', '6', '2021-05-03 19:13:35', null), ('17', '202105041053016056056', '6', null, '2', '400', '2021050301', '2021050401', 'P', null, null, '2021-05-04 10:53:01', '6', '2021-05-04 10:53:01', null);
COMMIT;

-- ----------------------------
--  Table structure for `storage_calender`
-- ----------------------------
DROP TABLE IF EXISTS `storage_calender`;
CREATE TABLE `storage_calender` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `model_id` int(11) DEFAULT NULL COMMENT '车型id',
  `time_slot_no` int(11) DEFAULT NULL COMMENT '时间槽编号，如2021050301',
  `max_available` int(11) DEFAULT NULL COMMENT '最大供给数',
  `remaining` int(11) DEFAULT NULL COMMENT '剩余可供给数量',
  `sts` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '状态 A生效 C失效',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_model_id` (`model_id`) USING BTREE,
  KEY `idx_time_slot_no` (`time_slot_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='库存日历';

-- ----------------------------
--  Records of `storage_calender`
-- ----------------------------
BEGIN;
INSERT INTO `storage_calender` VALUES ('6', '2', '2021050301', '2', '99', 'A', '2021-05-03 15:59:20', '1', '2021-05-04 10:53:01', null), ('7', '2', '2021050401', '2', '99', 'A', '2021-05-03 16:12:28', '1', '2021-05-04 10:53:01', null), ('8', '3', '2021050301', '5', '100', 'A', '2021-05-03 18:10:32', '1', '2021-05-04 10:20:47', null), ('9', '3', '2021050401', '5', '100', 'A', '2021-05-03 18:11:02', '1', '2021-05-04 10:20:50', null);
COMMIT;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_no` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '用户号',
  `user_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `sts` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '状态 A生效 C失效',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_user_name` (`user_name`) USING BTREE,
  KEY `idx_user_no` (`user_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('1', 'admin', 'admin', 'A', '2021-05-03 16:07:30', '1', '2021-05-03 16:08:22', null), ('6', 'Eric', 'Eric', 'A', '2021-05-03 16:07:14', '1', '2021-05-03 16:07:14', null), ('8', 'John', 'John', 'A', '2021-05-03 16:09:01', '1', '2021-05-03 16:09:01', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
