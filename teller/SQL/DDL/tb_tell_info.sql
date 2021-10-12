/*
 Navicat Premium Data Transfer

 Source Server         : 82
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 192.168.1.82:3306
 Source Schema         : option

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 12/10/2021 09:38:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_tell_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_tell_info`;
CREATE TABLE `tb_tell_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员名字',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `user_status` tinyint(4) NULL DEFAULT NULL COMMENT '管理员状态,0:正常，1：注销',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = tis620 COLLATE = tis620_thai_ci COMMENT = '管理员表(MyISAM)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_tell_info
-- ----------------------------
INSERT INTO `tb_tell_info` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 0, NULL, NULL);
INSERT INTO `tb_tell_info` VALUES (5, 'user1', 'e10adc3949ba59abbe56e057f20f883e', 0, 50355, 50355);

SET FOREIGN_KEY_CHECKS = 1;
