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

 Date: 12/10/2021 09:37:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_privilege_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_privilege_info`;
CREATE TABLE `tb_privilege_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `menu_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单ID',
  `menu_level` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单级别：1=1级目录,2=2级目录',
  `menu_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `pre_menu_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级菜单id',
  `sort` int(10) NULL DEFAULT NULL COMMENT '当前目录基本排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_privilege_info
-- ----------------------------
INSERT INTO `tb_privilege_info` VALUES (1, '1', '1', '基本操作', '', '0', 1);
INSERT INTO `tb_privilege_info` VALUES (2, '1-1', '2', '证券一体化服务期状态', '/main/basicOpt/bondSvsStatus', '1', 1);
INSERT INTO `tb_privilege_info` VALUES (3, '1-2', '2', '角色权限授权', '/main/basicOpt/rolePrlg', '1', 2);
INSERT INTO `tb_privilege_info` VALUES (4, '2', '1', '千档行情历史信息', '', '0', 2);
INSERT INTO `tb_privilege_info` VALUES (5, '2-1', '2', '深市行情', '/main/mktHis/szMkt', '2', 1);
INSERT INTO `tb_privilege_info` VALUES (6, '2-2', '2', '千档行情', '/main/mktHis/thousandMkt', '2', 2);

SET FOREIGN_KEY_CHECKS = 1;
