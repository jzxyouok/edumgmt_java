-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 192.168.1.226    Database: sh_eduonline
-- ------------------------------------------------------
-- Server version	5.1.73

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sh_admin_user`
--

DROP TABLE IF EXISTS `sh_admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_admin_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_company_id` int(11) unsigned NOT NULL,
  `realname` varchar(64) DEFAULT NULL COMMENT '管理用户真实姓名',
  `nickname` varchar(64) NOT NULL COMMENT '管理用户昵称（登陆名）',
  `password` varchar(64) NOT NULL COMMENT '登陆密码',
  `sex` enum('0','1') DEFAULT '1' COMMENT '性别：0-女，1-男，默认为1',
  `address` varchar(64) DEFAULT NULL COMMENT '通讯地址',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(24) DEFAULT NULL COMMENT '联系电话',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `enabled` enum('0','1') NOT NULL DEFAULT '1' COMMENT '是否启用管理用户：0-不启用，1-启用',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `position` varchar(16) DEFAULT NULL COMMENT '职位',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  KEY `uix_sh_admin_user` (`sh_company_id`,`nickname`),
  KEY `fk_sh_admin_user_sh_company1_idx` (`sh_company_id`),
  CONSTRAINT `fk_sh_admin_user_sh_company1` FOREIGN KEY (`sh_company_id`) REFERENCES `sh_company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='后台管理用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_admin_user_has_sh_authority_group`
--

DROP TABLE IF EXISTS `sh_admin_user_has_sh_authority_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_admin_user_has_sh_authority_group` (
  `sh_admin_user_id` int(11) unsigned NOT NULL,
  `sh_authority_group_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`sh_admin_user_id`,`sh_authority_group_id`),
  KEY `fk_sh_admin_user_has_sh_authority_group_sh_authority_group1_idx` (`sh_authority_group_id`),
  KEY `fk_sh_admin_user_has_sh_authority_group_sh_admin_user1_idx` (`sh_admin_user_id`),
  CONSTRAINT `fk_sh_admin_user_has_sh_authority_group_sh_admin_user1` FOREIGN KEY (`sh_admin_user_id`) REFERENCES `sh_admin_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_admin_user_has_sh_authority_group_sh_authority_group1` FOREIGN KEY (`sh_authority_group_id`) REFERENCES `sh_authority_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_area`
--

DROP TABLE IF EXISTS `sh_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_area` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) unsigned DEFAULT NULL COMMENT '父级id',
  `code` varchar(32) DEFAULT NULL COMMENT '区域代码',
  `name` varchar(64) DEFAULT NULL COMMENT '区域名称',
  `enabled` enum('0','1') NOT NULL DEFAULT '1' COMMENT '是否开启该地区：1-开启，0-关闭',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1562 DEFAULT CHARSET=utf8 COMMENT='区域表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_authority`
--

DROP TABLE IF EXISTS `sh_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_authority` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_company_id` int(11) unsigned NOT NULL,
  `authority` varchar(32) NOT NULL COMMENT '权限描述',
  `remark` varchar(32) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `uix_sh_autority` (`authority`),
  KEY `fk_sh_authority_sh_company1_idx` (`sh_company_id`),
  CONSTRAINT `fk_sh_authority_sh_company1` FOREIGN KEY (`sh_company_id`) REFERENCES `sh_company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='管理用户权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_authority_group`
--

DROP TABLE IF EXISTS `sh_authority_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_authority_group` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_company_id` int(11) unsigned NOT NULL,
  `name` varchar(45) NOT NULL COMMENT '组名代码',
  `remark` varchar(45) DEFAULT NULL COMMENT '组名解释',
  PRIMARY KEY (`id`),
  KEY `uix_authority_group` (`sh_company_id`,`name`),
  KEY `fk_sh_authority_group_sh_company1_idx` (`sh_company_id`),
  CONSTRAINT `fk_sh_authority_group_sh_company1` FOREIGN KEY (`sh_company_id`) REFERENCES `sh_company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='权限组';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_authority_group_has_sh_authority`
--

DROP TABLE IF EXISTS `sh_authority_group_has_sh_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_authority_group_has_sh_authority` (
  `sh_authority_group_id` int(11) unsigned NOT NULL,
  `sh_authority_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`sh_authority_group_id`,`sh_authority_id`),
  KEY `fk_sh_authority_group_has_sh_authority1_sh_authority1_idx` (`sh_authority_id`),
  KEY `fk_sh_authority_group_has_sh_authority1_sh_authority_group1_idx` (`sh_authority_group_id`),
  CONSTRAINT `fk_sh_authority_group_has_sh_authority1_sh_authority1` FOREIGN KEY (`sh_authority_id`) REFERENCES `sh_authority` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_authority_group_has_sh_authority1_sh_authority_group1` FOREIGN KEY (`sh_authority_group_id`) REFERENCES `sh_authority_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_book`
--

DROP TABLE IF EXISTS `sh_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_parter_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `status` varchar(1) NOT NULL DEFAULT '1' COMMENT '0关1开',
  `num_reservation` varchar(6) NOT NULL COMMENT '预定视频数量',
  PRIMARY KEY (`id`),
  KEY `fk_sh_book_sh_parter1_idx` (`sh_parter_id`),
  CONSTRAINT `fk_sh_book_sh_parter1` FOREIGN KEY (`sh_parter_id`) REFERENCES `sh_parter` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='书';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_collection`
--

DROP TABLE IF EXISTS `sh_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_user_id` int(11) DEFAULT NULL,
  `sh_video_base_id` int(11) DEFAULT NULL COMMENT '视频ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_company`
--

DROP TABLE IF EXISTS `sh_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_company` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company_name` varchar(64) NOT NULL COMMENT '公司名称',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `name` varchar(32) DEFAULT NULL COMMENT '联系人',
  `tel` varchar(32) DEFAULT NULL COMMENT '电话',
  `enabled` enum('0','1') NOT NULL DEFAULT '1' COMMENT '是否启用该公司：0-禁用，1-启用',
  `create_time` datetime NOT NULL COMMENT '添加时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_course`
--

DROP TABLE IF EXISTS `sh_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_course` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '课程名称',
  `short_name` varchar(32) DEFAULT NULL COMMENT '课程简写',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_course_grade`
--

DROP TABLE IF EXISTS `sh_course_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_course_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_course_id` int(11) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL COMMENT '1初中2高中',
  `sh_material_version_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sh_course_grade_sh_course1_idx` (`sh_course_id`),
  KEY `fk_sh_course_grade_sh_material_version1_idx` (`sh_material_version_id`),
  CONSTRAINT `fk_sh_course_grade_sh_course1` FOREIGN KEY (`sh_course_id`) REFERENCES `sh_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_course_grade_sh_material_version1` FOREIGN KEY (`sh_material_version_id`) REFERENCES `sh_material_version` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='课程年级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_course_grade_has_sh_video_base`
--

DROP TABLE IF EXISTS `sh_course_grade_has_sh_video_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_course_grade_has_sh_video_base` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_course_grade_id` int(11) unsigned NOT NULL,
  `sh_video_base_id` int(11) unsigned NOT NULL,
  `sort` int(6) NOT NULL,
  `add_time` datetime NOT NULL,
  `video_type` varchar(1) NOT NULL COMMENT '1真题模拟题2自编题3知识点',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uix_sh_course_has_video` (`sh_video_base_id`,`sh_course_grade_id`),
  KEY `fk_sh_course_grade_has_sh_video_base_sh_video_base1_idx` (`sh_video_base_id`),
  KEY `fk_sh_course_grade_has_sh_video_base_sh_course_grade1_idx` (`sh_course_grade_id`),
  CONSTRAINT `fk_sh_course_grade_has_sh_video_base_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='课程年级视频关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_feedback`
--

DROP TABLE IF EXISTS `sh_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_feedback` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sh_user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `content` text COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='意见反馈';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_grade`
--

DROP TABLE IF EXISTS `sh_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_grade` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(9) DEFAULT NULL COMMENT '年级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='年级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_keyword`
--

DROP TABLE IF EXISTS `sh_keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_keyword` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL COMMENT '关键字内容',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='关键字表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_knowledge_point`
--

DROP TABLE IF EXISTS `sh_knowledge_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_knowledge_point` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '知识点内容',
  `parent_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父级id',
  `sh_course_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sh_knowledge_point_sh_course1_idx` (`sh_course_id`),
  CONSTRAINT `fk_sh_knowledge_point_sh_course1` FOREIGN KEY (`sh_course_id`) REFERENCES `sh_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5612 DEFAULT CHARSET=utf8 COMMENT='知识点表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_lecture`
--

DROP TABLE IF EXISTS `sh_lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_lecture` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL COMMENT '讲解人姓名',
  `level` varchar(45) DEFAULT NULL COMMENT '讲解人级别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='视频讲解人表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_material_version`
--

DROP TABLE IF EXISTS `sh_material_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_material_version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `default` tinyint(1) DEFAULT '0' COMMENT '默认出版社 0-非默认	1-默认',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_SH_MATERIAL_VERSION` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='教材版本表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_notice`
--

DROP TABLE IF EXISTS `sh_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notice` varchar(255) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_parter`
--

DROP TABLE IF EXISTS `sh_parter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_parter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_SH_PARTER` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='书商表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_play_history`
--

DROP TABLE IF EXISTS `sh_play_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_play_history` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sh_user_id` int(11) DEFAULT NULL,
  `sh_video_base_id` int(11) DEFAULT NULL COMMENT '视频id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 COMMENT='播放历史';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_problem`
--

DROP TABLE IF EXISTS `sh_problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_problem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_book_id` int(11) NOT NULL,
  `seq` int(11) DEFAULT '0',
  `status` varchar(1) NOT NULL DEFAULT '1' COMMENT '0关1开',
  `content` varchar(256) DEFAULT NULL,
  `two_code` varchar(255) DEFAULT NULL,
  `two_code_content` varchar(128) DEFAULT NULL,
  `two_code_file_name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sh_problem_sh_book1_idx` (`sh_book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2569 DEFAULT CHARSET=utf8 COMMENT='题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_problem_has_sh_video_base`
--

DROP TABLE IF EXISTS `sh_problem_has_sh_video_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_problem_has_sh_video_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_problem_id` int(11) NOT NULL,
  `sh_video_base_id` int(11) unsigned NOT NULL,
  `video_type` varchar(1) NOT NULL COMMENT '1真题模拟题2自编题3知识点',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sh_problem_id_UNIQUE` (`sh_problem_id`,`sh_video_base_id`),
  KEY `fk_sh_problem_has_sh_video_base_sh_video_base1_idx` (`sh_video_base_id`),
  KEY `fk_sh_problem_has_sh_video_base_sh_problem1_idx` (`sh_problem_id`),
  CONSTRAINT `fk_sh_problem_has_sh_video_base_sh_problem1` FOREIGN KEY (`sh_problem_id`) REFERENCES `sh_problem` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_problem_has_sh_video_base_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='题和视频关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_pushmessage`
--

DROP TABLE IF EXISTS `sh_pushmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_pushmessage` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `content` longtext NOT NULL,
  `type` varchar(1) NOT NULL DEFAULT '0' COMMENT '消息类型,0=对所有用户推送，其他待扩展',
  `create_time` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='推送信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_question_has_sh_tag`
--

DROP TABLE IF EXISTS `sh_question_has_sh_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_question_has_sh_tag` (
  `sh_question_id` int(11) unsigned NOT NULL,
  `sh_tag_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`sh_question_id`,`sh_tag_id`),
  KEY `fk_sh_question_has_sh_tag_sh_question1_idx` (`sh_question_id`),
  CONSTRAINT `fk_sh_question_has_sh_tag_sh_question1` FOREIGN KEY (`sh_question_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_question_type`
--

DROP TABLE IF EXISTS `sh_question_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_question_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '题型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='题型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_questionbank`
--

DROP TABLE IF EXISTS `sh_questionbank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_questionbank` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL COMMENT '题库名称',
  `type` char(1) NOT NULL COMMENT '0=真题题库，1=自编题库（预留，暂时不用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='题库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_questionbank_course`
--

DROP TABLE IF EXISTS `sh_questionbank_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_questionbank_course` (
  `sh_questionbank_id` int(11) unsigned NOT NULL,
  `sh_course_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`sh_questionbank_id`,`sh_course_id`),
  KEY `fk_sh_questionbank_has_sh_course_sh_course1_idx` (`sh_course_id`),
  KEY `fk_sh_questionbank_has_sh_course_sh_questionbank1_idx` (`sh_questionbank_id`),
  CONSTRAINT `fk_sh_questionbank_has_sh_course_sh_course1` FOREIGN KEY (`sh_course_id`) REFERENCES `sh_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_questionbank_has_sh_course_sh_questionbank1` FOREIGN KEY (`sh_questionbank_id`) REFERENCES `sh_questionbank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库科目对应表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_questionbank_question_type`
--

DROP TABLE IF EXISTS `sh_questionbank_question_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_questionbank_question_type` (
  `sh_questionbank_id` int(11) unsigned NOT NULL,
  `sh_question_type_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`sh_questionbank_id`,`sh_question_type_id`),
  KEY `fk_sh_questionbank_has_sh_question_type_sh_question_type1_idx` (`sh_question_type_id`),
  KEY `fk_sh_questionbank_has_sh_question_type_sh_questionbank1_idx` (`sh_questionbank_id`),
  CONSTRAINT `fk_sh_questionbank_has_sh_question_type_sh_questionbank1` FOREIGN KEY (`sh_questionbank_id`) REFERENCES `sh_questionbank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_questionbank_has_sh_question_type_sh_question_type1` FOREIGN KEY (`sh_question_type_id`) REFERENCES `sh_question_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库题型对应关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_questionbank_type`
--

DROP TABLE IF EXISTS `sh_questionbank_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_questionbank_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_questionbank_id` int(11) unsigned NOT NULL,
  `name` varchar(16) NOT NULL COMMENT '题库版本名称',
  PRIMARY KEY (`id`),
  KEY `fk_sh_questionbank_type_sh_questionbank1_idx` (`sh_questionbank_id`),
  CONSTRAINT `fk_sh_questionbank_type_sh_questionbank1` FOREIGN KEY (`sh_questionbank_id`) REFERENCES `sh_questionbank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='题库版本表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_questionbank_year`
--

DROP TABLE IF EXISTS `sh_questionbank_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_questionbank_year` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_questionbank_id` int(11) unsigned NOT NULL,
  `year` varchar(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uidx_questionbank_year` (`sh_questionbank_id`,`year`),
  KEY `fk_sh_questionbank_year_sh_questionbank1_idx` (`sh_questionbank_id`),
  CONSTRAINT `fk_sh_questionbank_year_sh_questionbank1` FOREIGN KEY (`sh_questionbank_id`) REFERENCES `sh_questionbank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='真题模拟题所属年份关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_recommend`
--

DROP TABLE IF EXISTS `sh_recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `add_time` datetime NOT NULL,
  `top_time` datetime NOT NULL,
  `location` varchar(1) NOT NULL COMMENT '1位置12位置2位置3',
  `title` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `logo` varchar(128) NOT NULL,
  `type` varchar(1) DEFAULT NULL COMMENT '类型：1-视频库，2-课程库',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='推荐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_recommend_has_sh_course_grade`
--

DROP TABLE IF EXISTS `sh_recommend_has_sh_course_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_recommend_has_sh_course_grade` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_recommend_id` int(11) NOT NULL,
  `sh_course_grade_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sh_recommend_has_sh_course_grade_sh_course_grade1_idx` (`sh_course_grade_id`),
  KEY `fk_sh_recommend_has_sh_course_grade_sh_recommend1_idx` (`sh_recommend_id`),
  CONSTRAINT `fk_sh_recommend_has_sh_course_grade_sh_course_grade1` FOREIGN KEY (`sh_course_grade_id`) REFERENCES `sh_course_grade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_recommend_has_sh_course_grade_sh_recommend1` FOREIGN KEY (`sh_recommend_id`) REFERENCES `sh_recommend` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_recommend_has_sh_video_base`
--

DROP TABLE IF EXISTS `sh_recommend_has_sh_video_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_recommend_has_sh_video_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_recommend_id` int(11) NOT NULL,
  `sh_video_base_id` int(11) unsigned NOT NULL,
  `add_time` datetime NOT NULL,
  `top_time` datetime NOT NULL,
  `video_type` varchar(1) NOT NULL COMMENT '1真题模拟题2自编题3知识点',
  `dimension` varchar(1) NOT NULL COMMENT '筛选维度1初中2高中',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uix_sh_recommend_has_sh_video_base` (`sh_recommend_id`,`sh_video_base_id`),
  KEY `fk_sh_recommend_has_sh_video_base_sh_video_base1_idx` (`sh_video_base_id`),
  KEY `fk_sh_recommend_has_sh_video_base_sh_recommend1_idx` (`sh_recommend_id`),
  CONSTRAINT `fk_sh_recommend_has_sh_video_base_sh_recommend1` FOREIGN KEY (`sh_recommend_id`) REFERENCES `sh_recommend` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_recommend_has_sh_video_base_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='推荐视频关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_school`
--

DROP TABLE IF EXISTS `sh_school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_school` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_area_id` int(11) unsigned NOT NULL COMMENT '学校所在地',
  `name` varchar(32) DEFAULT NULL COMMENT '学校名称',
  PRIMARY KEY (`id`),
  KEY `fk_sh_school_sh_area_idx` (`sh_area_id`),
  CONSTRAINT `fk_sh_school_sh_area` FOREIGN KEY (`sh_area_id`) REFERENCES `sh_area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3420 DEFAULT CHARSET=utf8 COMMENT='学校表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_user`
--

DROP TABLE IF EXISTS `sh_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_area_id` int(11) unsigned DEFAULT NULL COMMENT '所在城市',
  `sh_grade_id` int(11) unsigned DEFAULT NULL COMMENT '所在年级',
  `sh_school_id` int(11) unsigned DEFAULT NULL COMMENT '所在学校',
  `user_class` varchar(60) DEFAULT NULL COMMENT '班级',
  `tel` varchar(11) NOT NULL COMMENT '手机号',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `name` varchar(16) DEFAULT NULL COMMENT '姓名',
  `nick` varchar(45) DEFAULT NULL COMMENT '昵称',
  `sex` enum('0','1') DEFAULT '0' COMMENT '性别：0-男，1-女',
  `face` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `sh_device_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sh_user_sh_area_idx` (`sh_area_id`),
  KEY `fk_sh_user_sh_grade_idx` (`sh_grade_id`),
  KEY `fk_sh_user_sh_school_idx` (`sh_school_id`),
  CONSTRAINT `fk_sh_user_sh_area` FOREIGN KEY (`sh_area_id`) REFERENCES `sh_area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_user_sh_grade` FOREIGN KEY (`sh_grade_id`) REFERENCES `sh_grade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_user_sh_school` FOREIGN KEY (`sh_school_id`) REFERENCES `sh_school` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_user_notice`
--

DROP TABLE IF EXISTS `sh_user_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_user_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `sh_notice_id` int(11) DEFAULT NULL COMMENT '消息id',
  `readed` varchar(45) DEFAULT NULL COMMENT '是否已读，0未读 ， 1已读',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_user_thirdpart_login`
--

DROP TABLE IF EXISTS `sh_user_thirdpart_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_user_thirdpart_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `platform` varchar(45) DEFAULT NULL,
  `platform_token` varchar(45) NOT NULL COMMENT '第三方的token',
  `platform_name` varchar(45) NOT NULL COMMENT '第三方平台上的用户名',
  `sh_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_vertify_code`
--

DROP TABLE IF EXISTS `sh_vertify_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_vertify_code` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `vertify_code` varchar(8) DEFAULT NULL COMMENT '验证码',
  `tel` varchar(11) DEFAULT NULL COMMENT '手机号',
  `live_time` int(11) DEFAULT NULL COMMENT '有效时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='验证码表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_video_base`
--

DROP TABLE IF EXISTS `sh_video_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_video_base` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_admin_user_id` int(11) unsigned NOT NULL COMMENT '后台管理用户id',
  `sh_course_id` int(11) unsigned NOT NULL,
  `sh_lecture_id` int(11) unsigned NOT NULL,
  `question_id` varchar(45) DEFAULT NULL COMMENT '题目ID',
  `title` varchar(256) NOT NULL COMMENT '视频标题',
  `desc` varchar(1024) DEFAULT NULL COMMENT '描述',
  `difficulty` varchar(1) NOT NULL COMMENT '难度系数 1 2 3 4 5',
  `status` varchar(1) NOT NULL DEFAULT '0' COMMENT '状态 0=已上架，1=未上架',
  `question_number` varchar(32) DEFAULT NULL COMMENT '题号',
  `profile` longtext COMMENT '简介',
  `updatetime` datetime NOT NULL COMMENT '更新时间',
  `qrcode` varchar(128) DEFAULT NULL COMMENT '二维码信息',
  PRIMARY KEY (`id`),
  KEY `fk_sh_question_pastpaper_sh_admin_user1_idx` (`sh_admin_user_id`),
  KEY `fk_sh_video_base_sh_course1_idx` (`sh_course_id`),
  KEY `fk_sh_video_base_sh_lecture1_idx` (`sh_lecture_id`),
  CONSTRAINT `fk_sh_question_pastpaper_sh_admin_user1` FOREIGN KEY (`sh_admin_user_id`) REFERENCES `sh_admin_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_base_sh_course1` FOREIGN KEY (`sh_course_id`) REFERENCES `sh_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_base_sh_lecture1` FOREIGN KEY (`sh_lecture_id`) REFERENCES `sh_lecture` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='视频公共基础信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_video_base_keyword`
--

DROP TABLE IF EXISTS `sh_video_base_keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_video_base_keyword` (
  `sh_video_base_id` int(11) unsigned NOT NULL,
  `sh_keyword_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`sh_video_base_id`,`sh_keyword_id`),
  KEY `fk_sh_video_base_has_sh_keyword_sh_keyword1_idx` (`sh_keyword_id`),
  KEY `fk_sh_video_base_has_sh_keyword_sh_video_base1_idx` (`sh_video_base_id`),
  CONSTRAINT `fk_sh_video_base_has_sh_keyword_sh_keyword1` FOREIGN KEY (`sh_keyword_id`) REFERENCES `sh_keyword` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_base_has_sh_keyword_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视频与关键字关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_video_base_knowledge_point`
--

DROP TABLE IF EXISTS `sh_video_base_knowledge_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_video_base_knowledge_point` (
  `sh_video_base_id` int(11) unsigned NOT NULL,
  `sh_knowledge_point_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`sh_video_base_id`,`sh_knowledge_point_id`),
  KEY `fk_sh_video_base_has_sh_knowledge_point_sh_knowledge_point1_idx` (`sh_knowledge_point_id`),
  KEY `fk_sh_video_base_has_sh_knowledge_point_sh_video_base1_idx` (`sh_video_base_id`),
  CONSTRAINT `fk_sh_video_base_has_sh_knowledge_point_sh_knowledge_point1` FOREIGN KEY (`sh_knowledge_point_id`) REFERENCES `sh_knowledge_point` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_base_has_sh_knowledge_point_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视频知识点关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_video_detail`
--

DROP TABLE IF EXISTS `sh_video_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_video_detail` (
  `sh_video_base_id` int(11) unsigned NOT NULL,
  `type` varchar(10) NOT NULL COMMENT '视频格式',
  `url` varchar(256) NOT NULL COMMENT '视频地址',
  `updatetime` datetime NOT NULL,
  `store_info` varchar(128) DEFAULT NULL,
  `store_type` varchar(1) DEFAULT NULL COMMENT '存储类型 0=自有服务器，1=其他服务器',
  `video_duration` varchar(45) DEFAULT NULL COMMENT '视频时长',
  PRIMARY KEY (`type`,`sh_video_base_id`),
  KEY `fk_sh_video_detail_sh_video_base1_idx` (`sh_video_base_id`),
  CONSTRAINT `fk_sh_video_detail_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同一个视频，不同格式的具体信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_video_pastpaper`
--

DROP TABLE IF EXISTS `sh_video_pastpaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_video_pastpaper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sh_video_base_id` int(11) unsigned NOT NULL,
  `sh_questionbank_id` int(11) unsigned NOT NULL,
  `sh_questionbank_year_id` int(11) unsigned NOT NULL,
  `sh_question_type_id` int(11) unsigned NOT NULL,
  `sh_questionbank_type_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sh_video_pastpaper_sh_questionbank1_idx` (`sh_questionbank_id`),
  KEY `fk_sh_video_pastpaper_sh_questionbank_year1_idx` (`sh_questionbank_year_id`),
  KEY `fk_sh_video_pastpaper_sh_video_base1_idx` (`sh_video_base_id`),
  KEY `fk_sh_video_pastpaper_sh_question_type1_idx` (`sh_question_type_id`),
  KEY `fk_sh_video_pastpaper_sh_questionbank_type1_idx` (`sh_questionbank_type_id`),
  CONSTRAINT `fk_sh_video_pastpaper_sh_questionbank1` FOREIGN KEY (`sh_questionbank_id`) REFERENCES `sh_questionbank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_pastpaper_sh_questionbank_type1` FOREIGN KEY (`sh_questionbank_type_id`) REFERENCES `sh_questionbank_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_pastpaper_sh_questionbank_year1` FOREIGN KEY (`sh_questionbank_year_id`) REFERENCES `sh_questionbank_year` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_pastpaper_sh_question_type1` FOREIGN KEY (`sh_question_type_id`) REFERENCES `sh_question_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_pastpaper_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='真题模拟题具体信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_video_pic`
--

DROP TABLE IF EXISTS `sh_video_pic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_video_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_video_base_id` int(11) unsigned NOT NULL,
  `title` varchar(64) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `store_info` varchar(64) DEFAULT NULL,
  `store_type` varchar(1) DEFAULT NULL COMMENT '存储类型 0=自有服务器，1=其他服务器',
  `url` varchar(255) DEFAULT NULL COMMENT '图片链接',
  PRIMARY KEY (`id`),
  KEY `fk_sh_video_pic_sh_video_base1_idx` (`sh_video_base_id`),
  CONSTRAINT `fk_sh_video_pic_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='视频的截图信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_video_point`
--

DROP TABLE IF EXISTS `sh_video_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_video_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_video_base_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sh_video_point_sh_video_base1_idx` (`sh_video_base_id`),
  CONSTRAINT `fk_sh_video_point_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='知识点信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sh_video_self`
--

DROP TABLE IF EXISTS `sh_video_self`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh_video_self` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sh_video_base_id` int(11) unsigned NOT NULL,
  `type` varchar(1) NOT NULL COMMENT '题目性质：0=改编，1=自编',
  `sh_question_type_id` int(11) unsigned NOT NULL,
  `resource` varchar(128) DEFAULT NULL COMMENT '改编题来源',
  PRIMARY KEY (`id`),
  KEY `fk_sh_video_self_sh_question_type1_idx` (`sh_question_type_id`),
  KEY `fk_sh_video_self_sh_video_base1_idx` (`sh_video_base_id`),
  CONSTRAINT `fk_sh_video_self_sh_question_type1` FOREIGN KEY (`sh_question_type_id`) REFERENCES `sh_question_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_self_sh_video_base1` FOREIGN KEY (`sh_video_base_id`) REFERENCES `sh_video_base` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='自编题信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'sh_eduonline'
--
/*!50003 DROP FUNCTION IF EXISTS `get_child_list` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`liaozhuoran`@`%` FUNCTION `get_child_list`(root_id INT) RETURNS text CHARSET utf8
BEGIN
   DECLARE s_temp text;
   DECLARE s_temp_child text;

   SET s_temp = '$';
   SET s_temp_child =cast(root_id AS CHAR);

   WHILE s_temp_child IS NOT NULL DO
     SET s_temp = concat(s_temp,',',s_temp_child);
     SELECT group_concat(id) INTO s_temp_child FROM category WHERE FIND_IN_SET(parent_id, s_temp_child)>0;
   END WHILE;
   RETURN s_temp;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-23 16:34:54
