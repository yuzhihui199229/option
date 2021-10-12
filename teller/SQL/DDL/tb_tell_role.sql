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

 Date: 12/10/2021 09:38:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_tell_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_tell_role`;
CREATE TABLE `tb_tell_role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tid` int(10) NULL DEFAULT NULL COMMENT '柜员表的用户id',
  `rid` int(10) NULL DEFAULT NULL COMMENT '角色表的id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tell_role_rid_ref_role`(`rid`) USING BTREE,
  INDEX `tell_role_rid_ref_tell`(`tid`) USING BTREE,
  CONSTRAINT `tell_role_rid_ref_role` FOREIGN KEY (`rid`) REFERENCES `tb_role_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tell_role_rid_ref_tell` FOREIGN KEY (`tid`) REFERENCES `tb_tell_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_tell_role
-- ----------------------------
INSERT INTO `tb_tell_role` VALUES (1, 1, 1);
INSERT INTO `tb_tell_role` VALUES (7, 5, 8);

SET FOREIGN_KEY_CHECKS = 1;
