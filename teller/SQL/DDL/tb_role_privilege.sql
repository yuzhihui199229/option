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

 Date: 12/10/2021 09:38:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_privilege`;
CREATE TABLE `tb_role_privilege`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `rid` int(10) NULL DEFAULT NULL COMMENT '角色表中的id',
  `pid` int(10) NULL DEFAULT NULL COMMENT '权限表中的id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_provilege_rid_ref_role`(`rid`) USING BTREE,
  INDEX `role_provilege_pid_ref_privilege`(`pid`) USING BTREE,
  CONSTRAINT `role_provilege_pid_ref_privilege` FOREIGN KEY (`pid`) REFERENCES `tb_privilege_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_provilege_rid_ref_role` FOREIGN KEY (`rid`) REFERENCES `tb_role_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_privilege
-- ----------------------------
INSERT INTO `tb_role_privilege` VALUES (1, 1, 1);
INSERT INTO `tb_role_privilege` VALUES (2, 1, 2);
INSERT INTO `tb_role_privilege` VALUES (3, 1, 3);
INSERT INTO `tb_role_privilege` VALUES (4, 1, 4);
INSERT INTO `tb_role_privilege` VALUES (5, 1, 5);
INSERT INTO `tb_role_privilege` VALUES (6, 1, 6);
INSERT INTO `tb_role_privilege` VALUES (16, 8, 1);
INSERT INTO `tb_role_privilege` VALUES (17, 8, 3);
INSERT INTO `tb_role_privilege` VALUES (18, 8, 5);

SET FOREIGN_KEY_CHECKS = 1;
