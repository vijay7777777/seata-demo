/*
 Navicat Premium Data Transfer

 Source Server         : self
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : seata_demo

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 20/09/2024 09:06:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_freeze_tbl
-- ----------------------------
DROP TABLE IF EXISTS `account_freeze_tbl`;
CREATE TABLE `account_freeze_tbl` (
  `xid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `freeze_money` int unsigned DEFAULT '0' COMMENT '冻结金额',
  `state` int DEFAULT NULL COMMENT '事务状态，0:try，1:confirm，2:cancel',
  PRIMARY KEY (`xid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of account_freeze_tbl
-- ----------------------------
BEGIN;
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:1279586607136972801', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:1279586607136972814', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:2738752177116084886', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:2738752177116084970', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490663144', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490663282', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490663296', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490663312', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490663696', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490663738', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490663972', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490664110', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490664210', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490664246', '100001', 0, 2);
INSERT INTO `account_freeze_tbl` (`xid`, `user_id`, `freeze_money`, `state`) VALUES ('192.168.0.14:8091:5494957612490664524', '100001', 0, 2);
COMMIT;

-- ----------------------------
-- Table structure for account_tbl
-- ----------------------------
DROP TABLE IF EXISTS `account_tbl`;
CREATE TABLE `account_tbl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `money` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of account_tbl
-- ----------------------------
BEGIN;
INSERT INTO `account_tbl` (`id`, `user_id`, `money`) VALUES (1, 100001, 40);
COMMIT;

-- ----------------------------
-- Table structure for order_tbl
-- ----------------------------
DROP TABLE IF EXISTS `order_tbl`;
CREATE TABLE `order_tbl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `commodity_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `count` int DEFAULT NULL,
  `money` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of order_tbl
-- ----------------------------
BEGIN;
INSERT INTO `order_tbl` (`id`, `user_id`, `commodity_code`, `count`, `money`) VALUES (146, 100001, '200001', 20, 20);
INSERT INTO `order_tbl` (`id`, `user_id`, `commodity_code`, `count`, `money`) VALUES (147, 100001, '200001', 20, 20);
COMMIT;

-- ----------------------------
-- Table structure for storage_tbl
-- ----------------------------
DROP TABLE IF EXISTS `storage_tbl`;
CREATE TABLE `storage_tbl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `count` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of storage_tbl
-- ----------------------------
BEGIN;
INSERT INTO `storage_tbl` (`id`, `commodity_code`, `count`) VALUES (1, '200001', 40);
COMMIT;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `branch_id` bigint NOT NULL COMMENT 'branch transaction id',
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'global transaction id',
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'undo_log context,such as serialization',
  `rollback_info` longblob NOT NULL COMMENT 'rollback info',
  `log_status` int NOT NULL COMMENT '0:normal status,1:defense status',
  `log_created` datetime(6) NOT NULL COMMENT 'create datetime',
  `log_modified` datetime(6) NOT NULL COMMENT 'modify datetime',
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='AT transaction mode undo table';

-- ----------------------------
-- Records of undo_log
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
