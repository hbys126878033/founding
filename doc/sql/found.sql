/*
 Navicat Premium Data Transfer

 Source Server         : localhost_root_123456
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : found

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 29/12/2020 13:18:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for inner_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `inner_admin_role`;
CREATE TABLE `inner_admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inner_admin_role
-- ----------------------------
INSERT INTO `inner_admin_role` VALUES (4, 1, 1);

-- ----------------------------
-- Table structure for inner_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `inner_role_auth`;
CREATE TABLE `inner_role_auth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `auth_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inner_role_auth
-- ----------------------------
INSERT INTO `inner_role_auth` VALUES (1, 1, 1);
INSERT INTO `inner_role_auth` VALUES (2, 1, 2);
INSERT INTO `inner_role_auth` VALUES (3, 1, 3);

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_acct` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录账号',
  `user_pswd` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录密码',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '昵称',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '邮件',
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_admin_loginAcct`(`login_acct`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 866 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'cl', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (2, 'kitty', 'e10adc3949ba59abbe56e057f20f883e', 'kitty', '369522616@qq.com', '2020-05-06 10:20:30');
INSERT INTO `t_admin` VALUES (579, 'cl1', 'Test1111', '管理员1', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (580, 'cl2', 'Test1111', '管理员2', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (581, 'cl3', 'Test1111', '管理员3', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (582, 'cl4', 'Test1111', '管理员4', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (583, 'cl5', 'Test1111', '管理员5', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (584, 'cl6', 'Test1111', '管理员6', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (585, 'cl7', 'Test1111', '管理员7', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (586, 'cl8', 'Test1111', '管理员8', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (587, 'cl9', 'Test1111', '管理员9', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (588, 'cl10', 'Test1111', '管理员10', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (589, 'cl11', 'Test1111', '管理员11', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (590, 'cl12', 'Test1111', '管理员12', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (591, 'cl13', 'Test1111', '管理员13', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (592, 'cl14', 'Test1111', '管理员14', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (593, 'cl15', 'Test1111', '管理员15', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (594, 'cl16', 'Test1111', '管理员16', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (595, 'cl17', 'Test1111', '管理员17', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (596, 'cl18', 'Test1111', '管理员18', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (597, 'cl19', 'Test1111', '管理员19', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (598, 'cl20', 'Test1111', '管理员20', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (599, 'cl21', 'Test1111', '管理员21', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (600, 'cl22', 'Test1111', '管理员22', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (601, 'cl23', 'Test1111', '管理员23', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (602, 'cl24', 'Test1111', '管理员24', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (603, 'cl25', 'Test1111', '管理员25', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (604, 'cl26', 'Test1111', '管理员26', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (605, 'cl27', 'Test1111', '管理员27', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (606, 'cl28', 'Test1111', '管理员28', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (607, 'cl29', 'Test1111', '管理员29', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (608, 'cl30', 'Test1111', '管理员30', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (609, 'cl31', 'Test1111', '管理员31', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (610, 'cl32', 'Test1111', '管理员32', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (611, 'cl33', 'Test1111', '管理员33', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (612, 'cl34', 'Test1111', '管理员34', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (613, 'cl35', 'Test1111', '管理员35', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (614, 'cl36', 'Test1111', '管理员36', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (615, 'cl37', 'Test1111', '管理员37', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (616, 'cl38', 'Test1111', '管理员38', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (617, 'cl39', 'Test1111', '管理员39', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (618, 'cl40', 'Test1111', '管理员40', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (619, 'cl41', 'Test1111', '管理员41', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (620, 'cl42', 'Test1111', '管理员42', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (621, 'cl43', 'Test1111', '管理员43', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (622, 'cl44', 'Test1111', '管理员44', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (623, 'cl45', 'Test1111', '管理员45', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (624, 'cl46', 'Test1111', '管理员46', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (625, 'cl47', 'Test1111', '管理员47', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (626, 'cl48', 'Test1111', '管理员48', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (627, 'cl49', 'Test1111', '管理员49', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (628, 'cl50', 'Test1111', '管理员50', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (629, 'cl51', 'Test1111', '管理员51', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (630, 'cl52', 'Test1111', '管理员52', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (631, 'cl53', 'Test1111', '管理员53', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (632, 'cl54', 'Test1111', '管理员54', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (633, 'cl55', 'Test1111', '管理员55', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (634, 'cl56', 'Test1111', '管理员56', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (635, 'cl57', 'Test1111', '管理员57', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (636, 'cl58', 'Test1111', '管理员58', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (637, 'cl59', 'Test1111', '管理员59', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (638, 'cl60', 'Test1111', '管理员60', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (639, 'cl61', 'Test1111', '管理员61', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (640, 'cl62', 'Test1111', '管理员62', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (641, 'cl63', 'Test1111', '管理员63', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (642, 'cl64', 'Test1111', '管理员64', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (643, 'cl65', 'Test1111', '管理员65', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (644, 'cl66', 'Test1111', '管理员66', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (645, 'cl67', 'Test1111', '管理员67', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (646, 'cl68', 'Test1111', '管理员68', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (647, 'cl69', 'Test1111', '管理员69', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (648, 'cl70', 'Test1111', '管理员70', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (649, 'cl71', 'Test1111', '管理员71', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (650, 'cl72', 'Test1111', '管理员72', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (651, 'cl73', 'Test1111', '管理员73', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (652, 'cl74', 'Test1111', '管理员74', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (653, 'cl75', 'Test1111', '管理员75', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (654, 'cl76', 'Test1111', '管理员76', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (655, 'cl77', 'Test1111', '管理员77', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (656, 'cl78', 'Test1111', '管理员78', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (657, 'cl79', 'Test1111', '管理员79', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (658, 'cl80', 'Test1111', '管理员80', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (659, 'cl81', 'Test1111', '管理员81', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (660, 'cl82', 'Test1111', '管理员82', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (661, 'cl83', 'Test1111', '管理员83', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (662, 'cl84', 'Test1111', '管理员84', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (663, 'cl85', 'Test1111', '管理员85', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (664, 'cl86', 'Test1111', '管理员86', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (665, 'cl87', 'Test1111', '管理员87', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (666, 'cl88', 'Test1111', '管理员88', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (667, 'cl89', 'Test1111', '管理员89', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (668, 'cl90', 'Test1111', '管理员90', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (669, 'cl91', 'Test1111', '管理员91', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (670, 'cl92', 'Test1111', '管理员92', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (671, 'cl93', 'Test1111', '管理员93', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (672, 'cl94', 'Test1111', '管理员94', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (673, 'cl95', 'Test1111', '管理员95', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (674, 'cl96', 'Test1111', '管理员96', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (675, 'cl97', 'Test1111', '管理员97', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (676, 'cl98', 'Test1111', '管理员98', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (677, 'cl99', 'Test1111', '管理员99', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (678, 'cl100', 'Test1111', '管理员100', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (679, 'cl101', 'Test1111', '管理员101', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (680, 'cl102', 'Test1111', '管理员102', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (681, 'cl103', 'Test1111', '管理员103', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (682, 'cl104', 'Test1111', '管理员104', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (683, 'cl105', 'Test1111', '管理员105', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (684, 'cl106', 'Test1111', '管理员106', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (685, 'cl107', 'Test1111', '管理员107', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (686, 'cl108', 'Test1111', '管理员108', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (687, 'cl109', 'Test1111', '管理员109', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (688, 'cl110', 'Test1111', '管理员110', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (689, 'cl111', 'Test1111', '管理员111', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (690, 'cl112', 'Test1111', '管理员112', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (691, 'cl113', 'Test1111', '管理员113', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (692, 'cl114', 'Test1111', '管理员114', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (693, 'cl115', 'Test1111', '管理员115', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (694, 'cl116', 'Test1111', '管理员116', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (695, 'cl117', 'Test1111', '管理员117', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (696, 'cl118', 'Test1111', '管理员118', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (697, 'cl119', 'Test1111', '管理员119', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (698, 'cl120', 'Test1111', '管理员120', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (699, 'cl121', 'Test1111', '管理员121', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (700, 'cl122', 'Test1111', '管理员122', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (701, 'cl123', 'Test1111', '管理员123', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (702, 'cl124', 'Test1111', '管理员124', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (703, 'cl125', 'Test1111', '管理员125', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (704, 'cl126', 'Test1111', '管理员126', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (705, 'cl127', 'Test1111', '管理员127', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (706, 'cl128', 'Test1111', '管理员128', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (707, 'cl129', 'Test1111', '管理员129', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (708, 'cl130', 'Test1111', '管理员130', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (709, 'cl131', 'Test1111', '管理员131', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (710, 'cl132', 'Test1111', '管理员132', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (711, 'cl133', 'Test1111', '管理员133', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (712, 'cl134', 'Test1111', '管理员134', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (713, 'cl135', 'Test1111', '管理员135', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (714, 'cl136', 'Test1111', '管理员136', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (715, 'cl137', 'Test1111', '管理员137', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (716, 'cl138', 'Test1111', '管理员138', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (717, 'cl139', 'Test1111', '管理员139', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (718, 'cl140', 'Test1111', '管理员140', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (719, 'cl141', 'Test1111', '管理员141', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (720, 'cl142', 'Test1111', '管理员142', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (721, 'cl143', 'Test1111', '管理员143', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (722, 'cl144', 'Test1111', '管理员144', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (723, 'cl145', 'Test1111', '管理员145', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (724, 'cl146', 'Test1111', '管理员146', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (725, 'cl147', 'Test1111', '管理员147', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (726, 'cl148', 'Test1111', '管理员148', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (727, 'cl149', 'Test1111', '管理员149', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (728, 'cl150', 'Test1111', '管理员150', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (729, 'cl151', 'Test1111', '管理员151', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (730, 'cl152', 'Test1111', '管理员152', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (731, 'cl153', 'Test1111', '管理员153', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (732, 'cl154', 'Test1111', '管理员154', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (733, 'cl155', 'Test1111', '管理员155', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (734, 'cl156', 'Test1111', '管理员156', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (735, 'cl157', 'Test1111', '管理员157', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (736, 'cl158', 'Test1111', '管理员158', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (737, 'cl159', 'Test1111', '管理员159', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (738, 'cl160', 'Test1111', '管理员160', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (739, 'cl161', 'Test1111', '管理员161', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (740, 'cl162', 'Test1111', '管理员162', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (741, 'cl163', 'Test1111', '管理员163', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (742, 'cl164', 'Test1111', '管理员164', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (743, 'cl165', 'Test1111', '管理员165', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (744, 'cl166', 'Test1111', '管理员166', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (745, 'cl167', 'Test1111', '管理员167', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (746, 'cl168', 'Test1111', '管理员168', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (747, 'cl169', 'Test1111', '管理员169', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (748, 'cl170', 'Test1111', '管理员170', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (749, 'cl171', 'Test1111', '管理员171', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (750, 'cl172', 'Test1111', '管理员172', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (751, 'cl173', 'Test1111', '管理员173', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (752, 'cl174', 'Test1111', '管理员174', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (753, 'cl175', 'Test1111', '管理员175', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (754, 'cl176', 'Test1111', '管理员176', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (755, 'cl177', 'Test1111', '管理员177', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (756, 'cl178', 'Test1111', '管理员178', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (757, 'cl179', 'Test1111', '管理员179', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (758, 'cl180', 'Test1111', '管理员180', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (759, 'cl181', 'Test1111', '管理员181', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (760, 'cl182', 'Test1111', '管理员182', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (761, 'cl183', 'Test1111', '管理员183', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (762, 'cl184', 'Test1111', '管理员184', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (763, 'cl185', 'Test1111', '管理员185', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (764, 'cl186', 'Test1111', '管理员186', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (765, 'cl187', 'Test1111', '管理员187', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (766, 'cl188', 'Test1111', '管理员188', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (767, 'cl189', 'Test1111', '管理员189', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (768, 'cl190', 'Test1111', '管理员190', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (769, 'cl191', 'Test1111', '管理员191', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (770, 'cl192', 'Test1111', '管理员192', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (771, 'cl193', 'Test1111', '管理员193', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (772, 'cl194', 'Test1111', '管理员194', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (773, 'cl195', 'Test1111', '管理员195', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (774, 'cl196', 'Test1111', '管理员196', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (775, 'cl197', 'Test1111', '管理员197', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (776, 'cl198', 'Test1111', '管理员198', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (777, 'cl199', 'Test1111', '管理员199', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (778, 'cl200', 'Test1111', '管理员200', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (779, 'cl201', 'Test1111', '管理员201', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (780, 'cl202', 'Test1111', '管理员202', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (781, 'cl203', 'Test1111', '管理员203', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (782, 'cl204', 'Test1111', '管理员204', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (783, 'cl205', 'Test1111', '管理员205', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (784, 'cl206', 'Test1111', '管理员206', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (785, 'cl207', 'Test1111', '管理员207', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (786, 'cl208', 'Test1111', '管理员208', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (787, 'cl209', 'Test1111', '管理员209', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (788, 'cl210', 'Test1111', '管理员210', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (789, 'cl211', 'Test1111', '管理员211', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (790, 'cl212', 'Test1111', '管理员212', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (791, 'cl213', 'Test1111', '管理员213', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (792, 'cl214', 'Test1111', '管理员214', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (793, 'cl215', 'Test1111', '管理员215', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (794, 'cl216', 'Test1111', '管理员216', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (795, 'cl217', 'Test1111', '管理员217', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (796, 'cl218', 'Test1111', '管理员218', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (797, 'cl219', 'Test1111', '管理员219', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (798, 'cl220', 'Test1111', '管理员220', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (799, 'cl221', 'Test1111', '管理员221', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (800, 'cl222', 'Test1111', '管理员222', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (801, 'cl223', 'Test1111', '管理员223', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (802, 'cl224', 'Test1111', '管理员224', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (803, 'cl225', 'Test1111', '管理员225', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (804, 'cl226', 'Test1111', '管理员226', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (805, 'cl227', 'Test1111', '管理员227', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (806, 'cl228', 'Test1111', '管理员228', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (807, 'cl229', 'Test1111', '管理员229', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (808, 'cl230', 'Test1111', '管理员230', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (809, 'cl231', 'Test1111', '管理员231', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (810, 'cl232', 'Test1111', '管理员232', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (811, 'cl233', 'Test1111', '管理员233', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (812, 'cl234', 'Test1111', '管理员234', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (813, 'cl235', 'Test1111', '管理员235', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (814, 'cl236', 'Test1111', '管理员236', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (815, 'cl237', 'Test1111', '管理员237', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (816, 'cl238', 'Test1111', '管理员238', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (817, 'cl239', 'Test1111', '管理员239', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (818, 'cl240', 'Test1111', '管理员240', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (819, 'cl241', 'Test1111', '管理员241', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (820, 'cl242', 'Test1111', '管理员242', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (821, 'cl243', 'Test1111', '管理员243', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (822, 'cl244', 'Test1111', '管理员244', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (823, 'cl245', 'Test1111', '管理员245', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (824, 'cl246', 'Test1111', '管理员246', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (825, 'cl247', 'Test1111', '管理员247', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (826, 'cl248', 'Test1111', '管理员248', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (827, 'cl249', 'Test1111', '管理员249', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (828, 'cl250', 'Test1111', '管理员250', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (829, 'cl251', 'Test1111', '管理员251', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (830, 'cl252', 'Test1111', '管理员252', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (831, 'cl253', 'Test1111', '管理员253', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (832, 'cl254', 'Test1111', '管理员254', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (833, 'cl255', 'Test1111', '管理员255', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (834, 'cl256', 'Test1111', '管理员256', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (835, 'cl257', 'Test1111', '管理员257', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (836, 'cl258', 'Test1111', '管理员258', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (837, 'cl259', 'Test1111', '管理员259', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (838, 'cl260', 'Test1111', '管理员260', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (839, 'cl261', 'Test1111', '管理员261', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (840, 'cl262', 'Test1111', '管理员262', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (841, 'cl263', 'Test1111', '管理员263', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (842, 'cl264', 'Test1111', '管理员264', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (843, 'cl265', 'Test1111', '管理员265', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (844, 'cl266', 'Test1111', '管理员266', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (845, 'cl267', 'Test1111', '管理员267', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (846, 'cl268', 'Test1111', '管理员268', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (847, 'cl269', 'Test1111', '管理员269', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (848, 'cl270', 'Test1111', '管理员270', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (849, 'cl271', 'Test1111', '管理员271', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (850, 'cl272', 'Test1111', '管理员272', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (851, 'cl273', 'Test1111', '管理员273', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (852, 'cl274', 'Test1111', '管理员274', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (853, 'cl275', 'Test1111', '管理员275', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (854, 'cl276', 'Test1111', '管理员276', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (855, 'cl277', 'Test1111', '管理员277', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (856, 'cl278', 'Test1111', '管理员278', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (857, 'cl279', 'Test1111', '管理员279', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (858, 'cl280', 'Test1111', '管理员280', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (859, 'cl281', 'Test1111', '管理员281', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (860, 'cl282', 'Test1111', '管理员282', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (861, 'cl283', 'Test1111', '管理员283', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (862, 'cl284', 'Test1111', '管理员284', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (863, 'cl285', 'Test1111', '管理员285', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (864, 'cl286', 'Test1111', '管理员286', '863533952@qq.com', '2020-05-05 22:00:00');
INSERT INTO `t_admin` VALUES (865, 'cl287', 'Test1111', '管理员287', '863533952@qq.com', '2020-05-05 22:00:00');

-- ----------------------------
-- Table structure for t_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_auth`;
CREATE TABLE `t_auth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `category_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_auth
-- ----------------------------
INSERT INTO `t_auth` VALUES (1, '', '用户模块', NULL);
INSERT INTO `t_auth` VALUES (2, 'user:delete', '删除', 1);
INSERT INTO `t_auth` VALUES (3, 'user:get', '查询', 1);
INSERT INTO `t_auth` VALUES (4, '', '角色模块', NULL);
INSERT INTO `t_auth` VALUES (5, 'role:delete', '删除', 4);
INSERT INTO `t_auth` VALUES (6, 'role:get', '查询', 4);
INSERT INTO `t_auth` VALUES (7, 'role:add', '新增', 4);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, NULL, '系统权限菜单', NULL, 'glyphicon glyphicon-th-list');
INSERT INTO `t_menu` VALUES (2, 1, '控 制 面 板', 'main.htm', 'glyphicon glyphicon-dashboard');
INSERT INTO `t_menu` VALUES (3, 1, '权限管理', NULL, 'glyphicon glyphicon glyphicon-tasks');
INSERT INTO `t_menu` VALUES (4, 3, ' 用 户 维 护 ', 'user/index.htm', 'glyphicon glyphicon-user');
INSERT INTO `t_menu` VALUES (5, 3, ' 角 色 维 护 ', 'role/index.htm', 'glyphicon glyphicon-king');
INSERT INTO `t_menu` VALUES (6, 3, ' 菜 单 维 护 ', 'permission/index.htm', 'glyphicon glyphicon-lock');
INSERT INTO `t_menu` VALUES (7, 1, ' 业 务 审 核 ', NULL, 'glyphicon glyphicon-ok');
INSERT INTO `t_menu` VALUES (8, 7, ' 实 名 认 证 审 核 ', 'auth_cert/index.htm', 'glyphicon glyphicon-check');
INSERT INTO `t_menu` VALUES (9, 7, ' 广 告 审 核 ', 'auth_adv/index.htm', 'glyphicon glyphicon-check');
INSERT INTO `t_menu` VALUES (10, 7, ' 项 目 审 核 ', 'auth_project/index.htm', 'glyphicon glyphicon-check');
INSERT INTO `t_menu` VALUES (11, 1, ' 业 务 管 理 ', NULL, 'glyphicon glyphicon-th-large');
INSERT INTO `t_menu` VALUES (12, 11, ' 资 质 维 护 ', 'cert/index.htm', 'glyphicon glyphicon-picture');
INSERT INTO `t_menu` VALUES (13, 11, ' 分 类 管 理 ', 'certtype/index.htm', 'glyphicon glyphicon-equalizer');
INSERT INTO `t_menu` VALUES (14, 11, ' 流 程 管 理 ', 'process/index.htm', 'glyphicon glyphicon-random');
INSERT INTO `t_menu` VALUES (15, 11, ' 广 告 管 理 ', 'advert/index.htm', 'glyphicon glyphicon-hdd');
INSERT INTO `t_menu` VALUES (16, 11, ' 消 息 模 板 ', 'message/index.htm', 'glyphicon glyphicon-comment');
INSERT INTO `t_menu` VALUES (17, 11, ' 项 目 分 类 ', 'projectType/index.htm', 'glyphicon glyphicon-list');
INSERT INTO `t_menu` VALUES (18, 11, ' 项 目 标 签 ', 'tag/index.htm', 'glyphicon glyphicon-tags');
INSERT INTO `t_menu` VALUES (19, 1, ' 参 数 管 理 ', 'param/index.htm', 'glyphicon glyphicon-list-alt');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员');
INSERT INTO `t_role` VALUES (2, '13213888');
INSERT INTO `t_role` VALUES (3, 'cesss1');
INSERT INTO `t_role` VALUES (6, '12344');

SET FOREIGN_KEY_CHECKS = 1;
