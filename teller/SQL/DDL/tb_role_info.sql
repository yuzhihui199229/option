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

 Date: 12/10/2021 09:38:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_role_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_info`;
CREATE TABLE `tb_role_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) NOT NULL COMMENT '角色id',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_info
-- ----------------------------
INSERT INTO `tb_role_info` VALUES (1, 1, '管理员', NULL, NULL);
INSERT INTO `tb_role_info` VALUES (2, 2, '柜员管理员', NULL, NULL);
INSERT INTO `tb_role_info` VALUES (8, 3, '柜员端', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
