/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : xiaozhan

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 25/10/2021 11:59:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_addclass
-- ----------------------------
DROP TABLE IF EXISTS `t_addclass`;
CREATE TABLE `t_addclass` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `classname` varchar(20) NOT NULL COMMENT '班级名称',
  `payitem_id` varchar(100) NOT NULL COMMENT '收费项目',
  `startlesson` varchar(20) NOT NULL COMMENT '开课时间',
  `endlesson` varchar(20) NOT NULL COMMENT '结课时间',
  `state` int(10) NOT NULL COMMENT '状态（1.开课中  2.暂停中 3.已结束）',
  `teacher` varchar(20) NOT NULL COMMENT '教师',
  `classnum` int(10) NOT NULL COMMENT '课时数',
  `capacity` int(20) NOT NULL COMMENT '容量',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_addclass
-- ----------------------------
BEGIN;
INSERT INTO `t_addclass` VALUES (1, '一班', '1', '2021-02-01', '2021-03-01', 1, '李鑫', 45, 20);
INSERT INTO `t_addclass` VALUES (2, '二班', '1', '2021-06-09', '2021-09-09', 1, '李子计', 30, 50);
COMMIT;

-- ----------------------------
-- Table structure for t_followstate
-- ----------------------------
DROP TABLE IF EXISTS `t_followstate`;
CREATE TABLE `t_followstate` (
  `ID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `student_id` int(20) NOT NULL COMMENT '试听学生的id',
  `date` varchar(20) NOT NULL COMMENT '时间',
  `follow` varchar(20) NOT NULL COMMENT '跟进人',
  `content` varchar(50) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_listening
-- ----------------------------
DROP TABLE IF EXISTS `t_listening`;
CREATE TABLE `t_listening` (
  `ID` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `classtype` int(20) NOT NULL COMMENT '班型',
  `teacher` varchar(50) NOT NULL COMMENT '教师',
  `tele` varchar(20) NOT NULL COMMENT '家长联系方式',
  `visitor` varchar(20) NOT NULL COMMENT '课程顾问',
  `dtin` varchar(20) NOT NULL COMMENT '试听时间',
  `studentfrom` int(10) NOT NULL COMMENT '学生来源，1直访，2热线，3市场，4其他',
  `state` int(10) NOT NULL COMMENT '试听状态，1 未试听，2 已试听，3 已入学',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_month_jieyu
-- ----------------------------
DROP TABLE IF EXISTS `t_month_jieyu`;
CREATE TABLE `t_month_jieyu` (
  `ye` int(11) DEFAULT NULL,
  `mon` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  KEY `idx_ye_mo` (`ye`,`mon`,`amount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_pay
-- ----------------------------
DROP TABLE IF EXISTS `t_pay`;
CREATE TABLE `t_pay` (
  `ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '收费ID',
  `student_id` int(20) NOT NULL COMMENT 't_student表中id',
  `class_id` int(20) NOT NULL COMMENT '班级表中班级id',
  `price` decimal(20,2) NOT NULL COMMENT '应收金额 从t_payitem中',
  `rate` decimal(20,2) NOT NULL COMMENT '折扣',
  `finalprice` int(20) NOT NULL COMMENT '实收金额(取整)',
  `pricetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收费时间',
  `state` int(20) unsigned NOT NULL DEFAULT '0' COMMENT '收费状态 1为新生 0为续费',
  `teacher_id` varchar(20) NOT NULL COMMENT '业绩归属人(教师)',
  `give` int(20) unsigned NOT NULL COMMENT '赠送 1为赠送课时 2为赠送物品',
  `give_lesson_num` varchar(20) DEFAULT '0' COMMENT '赠送课时节数',
  `give_money` varchar(20) DEFAULT '0' COMMENT '赠品的价格',
  `give_remarks` varchar(100) DEFAULT NULL COMMENT '赠品备注',
  `ifactive` int(20) NOT NULL DEFAULT '1' COMMENT '默认是1有效，退费后改成0 无效',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `student_id` (`student_id`) USING BTREE COMMENT 'student只能添加一次'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pay
-- ----------------------------
BEGIN;
INSERT INTO `t_pay` VALUES (1, 1, 1, 30.00, 0.70, 21, '2021-06-24 13:46:22', 0, '西门子', 2, '', '20', '拼图', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_payitem
-- ----------------------------
DROP TABLE IF EXISTS `t_payitem`;
CREATE TABLE `t_payitem` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `course` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `classtype` int(11) DEFAULT NULL COMMENT '1，2，3，4代表幼儿 3+，4+，5+，6+；\r\n5，6代表小学 9--12，12--16',
  `price` decimal(18,2) DEFAULT NULL COMMENT '原价',
  `rate` decimal(18,2) DEFAULT NULL COMMENT '折扣',
  `finalprice` decimal(18,2) DEFAULT NULL COMMENT '最终价格',
  `coursenum` int(11) DEFAULT NULL COMMENT '课时数',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_payitem
-- ----------------------------
BEGIN;
INSERT INTO `t_payitem` VALUES (1, 'BIANCHENG', 1, 20.00, 0.80, 20.00, 12);
COMMIT;

-- ----------------------------
-- Table structure for t_refund
-- ----------------------------
DROP TABLE IF EXISTS `t_refund`;
CREATE TABLE `t_refund` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '退费学生姓名',
  `student_id` int(20) NOT NULL COMMENT '学生id',
  `school` varchar(20) NOT NULL COMMENT '学校',
  `tele` varchar(20) NOT NULL,
  `class_id` int(20) NOT NULL,
  `fee` int(20) NOT NULL COMMENT '退费金额',
  `dt` varchar(20) NOT NULL COMMENT '退费时间',
  `sf_id` int(20) NOT NULL COMMENT '对应的收费记录id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_refund
-- ----------------------------
BEGIN;
INSERT INTO `t_refund` VALUES (1, '大富翁', 1, '111', '13113113131', 1, 10, '2021-07-04 14:03:46', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `name` varchar(50) NOT NULL COMMENT '学生名字',
  `sex` varchar(5) NOT NULL COMMENT '性别',
  `tele` varchar(11) NOT NULL COMMENT '家长联系方式',
  `school` varchar(100) NOT NULL COMMENT '学校',
  `state` int(11) NOT NULL COMMENT '1，在读  2，停课  3，结课',
  `birth` varchar(20) DEFAULT NULL COMMENT '学生生日',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `ifactive` int(1) NOT NULL DEFAULT '1' COMMENT '假删除默认1',
  `sfrom` int(20) unsigned NOT NULL COMMENT '学生来源，1直访，2热线，3市场，4其他',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES (1, '大富翁', '男', '13113113131', '111', 1, '1992-12-22', '', 1, 4);
INSERT INTO `t_student` VALUES (2, '但是方', '男', '13131313131', '广告', 1, '2000-11-11', '', 1, 2);
COMMIT;

-- ----------------------------
-- Table structure for t_student_review
-- ----------------------------
DROP TABLE IF EXISTS `t_student_review`;
CREATE TABLE `t_student_review` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `Student_id` int(50) NOT NULL COMMENT '学生ID',
  `Dt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '回访时间',
  `Content` varchar(255) NOT NULL COMMENT '回访内容',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_review
-- ----------------------------
BEGIN;
INSERT INTO `t_student_review` VALUES (1, 1, '2021-06-24 12:18:20', '此学生上课迟到');
COMMIT;

-- ----------------------------
-- Table structure for t_swipe
-- ----------------------------
DROP TABLE IF EXISTS `t_swipe`;
CREATE TABLE `t_swipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL COMMENT '学生id',
  `class_id` int(11) DEFAULT NULL COMMENT '班级id',
  `swipedt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '打卡时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `idcard` varchar(18) NOT NULL,
  `dtin` varchar(15) NOT NULL,
  `rolename` int(10) NOT NULL DEFAULT '1' COMMENT '教师权限：1添加修改查询教师信息 0注销的教师无权限',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
BEGIN;
INSERT INTO `t_teacher` VALUES (1, '行就', '男', '210113199710019980', '2021-10-21', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `rolename` int(10) NOT NULL DEFAULT '0' COMMENT '1前台 2课程顾问 3教学主管 4管理员',
  `teacher_id` int(10) NOT NULL DEFAULT '0' COMMENT '1为教师 0不为教师',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'lidongcheng', '1234', 1, 1);
INSERT INTO `t_user` VALUES (2, 'lidongcheng9888', '123', 2, 0);
INSERT INTO `t_user` VALUES (6, '656001694', '131231', 3, 1);
INSERT INTO `t_user` VALUES (7, 'legoadmin', '12345', 4, 0);
INSERT INTO `t_user` VALUES (8, 'tengbian521', 'tengbian521', 0, 0);
COMMIT;

-- ----------------------------
-- View structure for v_addclass
-- ----------------------------
DROP VIEW IF EXISTS `v_addclass`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_addclass` AS select `b`.`ID` AS `ID`,`b`.`classname` AS `classname`,`b`.`payitem_id` AS `payitem_id`,`b`.`startlesson` AS `startlesson`,`b`.`endlesson` AS `endlesson`,`b`.`state` AS `state`,`b`.`teacher` AS `teacher`,`b`.`capacity` AS `capacity`,`b`.`classnum` AS `classnum`,`a`.`course` AS `course`,`a`.`coursenum` AS `coursenum`,(case `a`.`classtype` when 1 then '3+' when 2 then '4+' when 3 then '5+' when 4 then '6+' when 5 then '7+' end) AS `classtype_name`,(case `b`.`state` when 1 then '开课中' when 2 then '暂停中' when 3 then '已结束' end) AS `state_name` from (`t_payitem` `a` join `t_addclass` `b`) where (`b`.`payitem_id` = `a`.`ID`);

-- ----------------------------
-- View structure for v_charge_ifactive
-- ----------------------------
DROP VIEW IF EXISTS `v_charge_ifactive`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_charge_ifactive` AS select `a`.`ID` AS `ID`,`a`.`student_id` AS `student_id`,`a`.`class_id` AS `class_id`,`a`.`price` AS `price`,`a`.`rate` AS `rate`,`a`.`finalprice` AS `finalprice`,`a`.`pricetime` AS `pricetime`,`a`.`ifactive` AS `ifactive`,`b`.`name` AS `student_name`,`b`.`sex` AS `sex`,`b`.`tele` AS `tele`,`b`.`school` AS `school`,`b`.`state` AS `state`,`b`.`remark` AS `remark` from (`t_pay` `a` join `t_student` `b`) where ((`a`.`student_id` = `b`.`ID`) and (`a`.`ifactive` = 1) and (`b`.`ifactive` = 1));

-- ----------------------------
-- View structure for v_class
-- ----------------------------
DROP VIEW IF EXISTS `v_class`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_class` AS select `b`.`ID` AS `ID`,`b`.`classname` AS `classname`,`b`.`payitem_id` AS `payitem_id`,`b`.`startlesson` AS `startlesson`,`b`.`endlesson` AS `endlesson`,`b`.`state` AS `state`,`b`.`teacher` AS `teacher`,`b`.`classnum` AS `classnum`,`a`.`course` AS `course`,`a`.`coursenum` AS `coursenum`,(case `a`.`classtype` when 1 then '3+' when 2 then '4+' when 3 then '5+' when 4 then '6+' when 5 then '7+' end) AS `classtype_name`,(case `b`.`state` when 1 then '开课中' when 2 then '暂停中' when 3 then '已结束' end) AS `state_name` from (`t_payitem` `a` join `t_addclass` `b`) where (`b`.`payitem_id` = `a`.`ID`);

-- ----------------------------
-- View structure for v_followstate
-- ----------------------------
DROP VIEW IF EXISTS `v_followstate`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_followstate` AS select `a`.`ID` AS `ID`,`a`.`student_id` AS `student_id`,`a`.`date` AS `date`,`a`.`follow` AS `follow`,`a`.`content` AS `content`,`b`.`name` AS `name` from (`t_followstate` `a` join `t_listening` `b`) where (`a`.`student_id` = `b`.`ID`);

-- ----------------------------
-- View structure for v_listening
-- ----------------------------
DROP VIEW IF EXISTS `v_listening`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_listening` AS select `a`.`ID` AS `ID`,`a`.`name` AS `name`,`a`.`classtype` AS `classtype`,`a`.`teacher` AS `teacher`,`a`.`tele` AS `tele`,`a`.`visitor` AS `visitor`,`a`.`dtin` AS `dtin`,(case `a`.`studentfrom` when 1 then '热线' when 2 then '直访' when 3 then '市场' when 4 then '其他' end) AS `studentfrom`,(case `a`.`state` when 1 then '开课中' when 2 then '暂停中' when 3 then '已结束' end) AS `state`,(case `a`.`classtype` when 1 then '3+' when 2 then '4+' when 3 then '5+' when 4 then '6+' when 5 then '7+' end) AS `classtype_name` from `t_listening` `a`;

-- ----------------------------
-- View structure for v_moneyplan
-- ----------------------------
DROP VIEW IF EXISTS `v_moneyplan`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_moneyplan` AS select `t_student`.`ID` AS `ID`,`t_student`.`name` AS `name`,`t_student`.`tele` AS `tele`,`t_addclass`.`classname` AS `classname`,`t_student`.`school` AS `school`,`t_addclass`.`startlesson` AS `startlesson`,`t_addclass`.`endlesson` AS `endlesson`,`t_pay`.`student_id` AS `student_id`,`t_pay`.`class_id` AS `class_id`,`t_payitem`.`course` AS `course`,`t_pay`.`finalprice` AS `finalprice`,`t_pay`.`pricetime` AS `pricetime`,`t_pay`.`ifactive` AS `ifactive` from (((`t_student` join `t_pay`) join `t_payitem`) join `t_addclass`) where ((((`t_student`.`ID` = `t_pay`.`student_id`) = `t_payitem`.`ID`) = `t_addclass`.`ID`) and (`t_pay`.`ifactive` = 1) and (`t_student`.`ifactive` = 1));

-- ----------------------------
-- View structure for v_pay
-- ----------------------------
DROP VIEW IF EXISTS `v_pay`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_pay` AS select `b`.`name` AS `student_name`,`b`.`sex` AS `sex`,`b`.`tele` AS `tele`,`b`.`school` AS `school`,`b`.`birth` AS `birth`,`c`.`classname` AS `classname`,`a`.`student_id` AS `student_id`,`a`.`ID` AS `sf_id`,`d`.`course` AS `course`,`d`.`coursenum` AS `coursenum`,`a`.`class_id` AS `class_id`,`a`.`price` AS `price`,`a`.`rate` AS `rate`,`a`.`finalprice` AS `finalprice`,`a`.`pricetime` AS `pricetime`,`a`.`ifactive` AS `ifactive`,(case `b`.`state` when 1 then '在读' when 2 then '停课' when 3 then '结课' end) AS `state_name`,(case `a`.`give` when 1 then '课时' when 2 then '物品' end) AS `give`,`a`.`give_lesson_num` AS `give_lesson_num`,`a`.`give_money` AS `give_money`,`a`.`give_remarks` AS `give_remarks` from (((`t_pay` `a` join `t_student` `b`) join `t_addclass` `c`) join `t_payitem` `d`) where ((`a`.`student_id` = `b`.`ID`) and (`c`.`ID` = `a`.`class_id`) and ((`b`.`ID` = `a`.`student_id`) = `d`.`ID`) and (`a`.`ifactive` = 1) and (`b`.`ifactive` = 1));

-- ----------------------------
-- View structure for v_pay2
-- ----------------------------
DROP VIEW IF EXISTS `v_pay2`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_pay2` AS select `t_student`.`ID` AS `ID`,`t_student`.`name` AS `name`,`t_pay`.`ID` AS `sf_id`,`t_pay`.`student_id` AS `student_id`,`t_pay`.`class_id` AS `class_id`,`t_payitem`.`course` AS `course`,`t_pay`.`price` AS `price`,`t_pay`.`rate` AS `rate`,`t_pay`.`finalprice` AS `finalprice`,`t_pay`.`pricetime` AS `pricetime`,`t_pay`.`ifactive` AS `ifactive` from ((`t_student` join `t_pay`) join `t_payitem`) where (((`t_student`.`ID` = `t_pay`.`student_id`) = `t_payitem`.`ID`) and (`t_pay`.`ifactive` = 1) and (`t_student`.`ifactive` = 1));

-- ----------------------------
-- View structure for v_payitem
-- ----------------------------
DROP VIEW IF EXISTS `v_payitem`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_payitem` AS select `t_payitem`.`ID` AS `id`,`t_payitem`.`course` AS `course`,`t_payitem`.`classtype` AS `classtype`,(case `t_payitem`.`classtype` when 1 then '幼儿3+' when 2 then '幼儿4+' when 3 then '幼儿5+' when 4 then '幼儿6+' when 5 then '小学9-12' when 6 then '小学12-16' end) AS `classtype_name`,`t_payitem`.`price` AS `price`,`t_payitem`.`rate` AS `rate`,`t_payitem`.`finalprice` AS `finalprice`,`t_payitem`.`coursenum` AS `coursenum` from `t_payitem`;

-- ----------------------------
-- View structure for v_shoufei_tongji
-- ----------------------------
DROP VIEW IF EXISTS `v_shoufei_tongji`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_shoufei_tongji` AS select `t_student`.`ID` AS `ID`,`t_student`.`name` AS `name`,`t_student`.`sex` AS `sex`,`t_student`.`birth` AS `birth`,`t_student`.`tele` AS `tele`,`t_student`.`school` AS `school`,(case `t_student`.`state` when 1 then '在读' when 2 then '停课' when 3 then '结课' end) AS `state_name`,`t_pay`.`finalprice` AS `finalprice`,`t_pay`.`pricetime` AS `pricetime` from (`t_student` join `t_pay`) where ((`t_student`.`ID` = `t_pay`.`student_id`) and (`t_student`.`ifactive` = 1));

-- ----------------------------
-- View structure for v_student
-- ----------------------------
DROP VIEW IF EXISTS `v_student`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_student` AS select `t_student`.`ID` AS `ID`,`t_student`.`name` AS `name`,`t_student`.`sex` AS `sex`,`t_student`.`tele` AS `tele`,`t_student`.`birth` AS `birth`,`t_student`.`school` AS `school`,(case `t_student`.`state` when 1 then '在读' when 2 then '停课' when 3 then '结课' end) AS `state_name`,(case `t_student`.`sfrom` when 1 then '热线' when 2 then '直访' when 3 then '市场' when 4 then '其他' end) AS `studentfrom` from `t_student` where (`t_student`.`ifactive` = 1);

-- ----------------------------
-- View structure for v_student_review
-- ----------------------------
DROP VIEW IF EXISTS `v_student_review`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_student_review` AS select `a`.`ID` AS `ID`,`a`.`Student_id` AS `Student_id`,`a`.`Dt` AS `Dt`,`a`.`Content` AS `Content`,`b`.`name` AS `name` from (`t_student_review` `a` join `t_student` `b`) where ((`a`.`Student_id` = `b`.`ID`) and (`b`.`ifactive` = 1));

-- ----------------------------
-- View structure for v_student_tongji
-- ----------------------------
DROP VIEW IF EXISTS `v_student_tongji`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_student_tongji` AS select `a`.`ID` AS `ID`,`a`.`name` AS `name`,`a`.`sex` AS `sex`,`a`.`tele` AS `tele`,`a`.`school` AS `school`,(case `a`.`state` when 1 then '在读' when 2 then '停课' when 3 then '结课' end) AS `state_name`,`a`.`birth` AS `birth`,`a`.`remark` AS `remark` from `t_student` `a` where ((`a`.`state` = 1) and (`a`.`ifactive` = 1));

-- ----------------------------
-- View structure for v_swipe
-- ----------------------------
DROP VIEW IF EXISTS `v_swipe`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_swipe` AS select `t_student`.`name` AS `name`,`t_student`.`sex` AS `sex`,`t_student`.`school` AS `school`,(case `t_student`.`state` when 1 then '在读' when 2 then '停课' when 3 then '结课' end) AS `state_name`,`t_student`.`tele` AS `tele`,`t_student`.`birth` AS `birth`,`t_swipe`.`id` AS `swipe_id`,`t_swipe`.`student_id` AS `student_id`,`t_swipe`.`class_id` AS `class_id`,`t_swipe`.`swipedt` AS `swipedt`,`t_addclass`.`classname` AS `classname` from ((`t_student` join `t_swipe`) join `t_addclass`) where (((`t_student`.`ID` = `t_swipe`.`student_id`) = `t_addclass`.`ID`) and (`t_student`.`ifactive` = 1));

-- ----------------------------
-- View structure for v_swipe_tongji
-- ----------------------------
DROP VIEW IF EXISTS `v_swipe_tongji`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_swipe_tongji` AS select `a`.`name` AS `name`,`a`.`sex` AS `sex`,`a`.`tele` AS `tele`,`a`.`school` AS `school`,(case `a`.`state` when 1 then '在读' when 2 then '停课' when 3 then '结课' end) AS `state_name`,`a`.`birth` AS `birth`,`b`.`student_id` AS `student_id`,`b`.`class_id` AS `class_id`,`b`.`swipedt` AS `swipedt`,`c`.`classname` AS `classname`,`c`.`teacher` AS `teacher` from ((`t_student` `a` join `t_swipe` `b`) join `t_addclass` `c`) where ((`a`.`ID` = `b`.`student_id`) and (`b`.`class_id` = `c`.`ID`) and (`a`.`ifactive` = 1));

-- ----------------------------
-- View structure for v_tuifei_tongji
-- ----------------------------
DROP VIEW IF EXISTS `v_tuifei_tongji`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_tuifei_tongji` AS select `t_student`.`ID` AS `student_id`,`t_student`.`name` AS `name`,`t_student`.`sex` AS `sex`,`t_student`.`birth` AS `birth`,`t_student`.`tele` AS `tele`,`t_student`.`school` AS `school`,(case `t_student`.`state` when 1 then '在读' when 2 then '停课' when 3 then '结课' end) AS `state_name`,`t_refund`.`fee` AS `refundprice`,`t_refund`.`dt` AS `refunddate` from (`t_student` join `t_refund`) where ((`t_student`.`ID` = `t_refund`.`student_id`) and (`t_student`.`ifactive` = 1));

SET FOREIGN_KEY_CHECKS = 1;
