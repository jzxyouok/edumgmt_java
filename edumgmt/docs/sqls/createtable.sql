-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sh_eduonline
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sh_eduonline
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sh_eduonline` DEFAULT CHARACTER SET utf8 ;
USE `sh_eduonline` ;

-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_company` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(64) NOT NULL COMMENT '公司名称',
  `address` VARCHAR(128) NULL DEFAULT NULL COMMENT '地址',
  `name` VARCHAR(32) NULL DEFAULT NULL COMMENT '联系人',
  `tel` VARCHAR(32) NULL DEFAULT NULL COMMENT '电话',
  `enabled` ENUM('0','1') NOT NULL DEFAULT '1' COMMENT '是否启用该公司：0-禁用，1-启用',
  `create_time` DATETIME NOT NULL COMMENT '添加时间',
  `update_time` DATETIME NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '企业表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_admin_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_admin_user` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_company_id` INT(11) UNSIGNED NOT NULL,
  `realname` VARCHAR(64) NULL DEFAULT NULL COMMENT '管理用户真实姓名',
  `nickname` VARCHAR(64) NOT NULL COMMENT '管理用户昵称（登陆名）',
  `password` VARCHAR(64) NOT NULL COMMENT '登陆密码',
  `sex` ENUM('0','1') NULL DEFAULT '1' COMMENT '性别：0-女，1-男，默认为1',
  `address` VARCHAR(64) NULL DEFAULT NULL COMMENT '通讯地址',
  `email` VARCHAR(32) NULL DEFAULT NULL COMMENT '邮箱',
  `tel` VARCHAR(24) NULL DEFAULT NULL COMMENT '联系电话',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL COMMENT '更新时间',
  `enabled` ENUM('0','1') NOT NULL DEFAULT '1' COMMENT '是否启用管理用户：0-不启用，1-启用',
  `remark` VARCHAR(128) NULL DEFAULT NULL COMMENT '备注',
  `position` VARCHAR(16) NULL DEFAULT NULL COMMENT '职位',
  `head_pic` VARCHAR(255) NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  INDEX `uix_sh_admin_user` (`sh_company_id` ASC, `nickname` ASC),
  INDEX `fk_sh_admin_user_sh_company1_idx` (`sh_company_id` ASC),
  CONSTRAINT `fk_sh_admin_user_sh_company1`
    FOREIGN KEY (`sh_company_id`)
    REFERENCES `sh_eduonline`.`sh_company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '后台管理用户表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_authority_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_authority_group` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_company_id` INT(11) UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL COMMENT '组名代码',
  `remark` VARCHAR(45) NULL DEFAULT NULL COMMENT '组名解释',
  PRIMARY KEY (`id`),
  INDEX `uix_authority_group` (`sh_company_id` ASC, `name` ASC),
  INDEX `fk_sh_authority_group_sh_company1_idx` (`sh_company_id` ASC),
  CONSTRAINT `fk_sh_authority_group_sh_company1`
    FOREIGN KEY (`sh_company_id`)
    REFERENCES `sh_eduonline`.`sh_company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '权限组';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_admin_user_has_sh_authority_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_admin_user_has_sh_authority_group` (
  `sh_admin_user_id` INT(11) UNSIGNED NOT NULL,
  `sh_authority_group_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`sh_admin_user_id`, `sh_authority_group_id`),
  INDEX `fk_sh_admin_user_has_sh_authority_group_sh_authority_group1_idx` (`sh_authority_group_id` ASC),
  INDEX `fk_sh_admin_user_has_sh_authority_group_sh_admin_user1_idx` (`sh_admin_user_id` ASC),
  CONSTRAINT `fk_sh_admin_user_has_sh_authority_group_sh_admin_user1`
    FOREIGN KEY (`sh_admin_user_id`)
    REFERENCES `sh_eduonline`.`sh_admin_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_admin_user_has_sh_authority_group_sh_authority_group1`
    FOREIGN KEY (`sh_authority_group_id`)
    REFERENCES `sh_eduonline`.`sh_authority_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_area` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` INT(11) UNSIGNED NULL DEFAULT NULL COMMENT '父级id',
  `code` VARCHAR(32) NULL DEFAULT NULL COMMENT '区域代码',
  `name` VARCHAR(64) NULL DEFAULT NULL COMMENT '区域名称',
  `enabled` ENUM('0','1') NOT NULL DEFAULT '1' COMMENT '是否开启该地区：1-开启，0-关闭',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '区域表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_authority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_authority` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_company_id` INT(11) UNSIGNED NOT NULL,
  `authority` VARCHAR(32) NOT NULL COMMENT '权限描述',
  `remark` VARCHAR(32) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  INDEX `uix_sh_autority` (`authority` ASC),
  INDEX `fk_sh_authority_sh_company1_idx` (`sh_company_id` ASC),
  CONSTRAINT `fk_sh_authority_sh_company1`
    FOREIGN KEY (`sh_company_id`)
    REFERENCES `sh_eduonline`.`sh_company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '管理用户权限表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_authority_group_has_sh_authority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_authority_group_has_sh_authority` (
  `sh_authority_group_id` INT(11) UNSIGNED NOT NULL,
  `sh_authority_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`sh_authority_group_id`, `sh_authority_id`),
  INDEX `fk_sh_authority_group_has_sh_authority1_sh_authority1_idx` (`sh_authority_id` ASC),
  INDEX `fk_sh_authority_group_has_sh_authority1_sh_authority_group1_idx` (`sh_authority_group_id` ASC),
  CONSTRAINT `fk_sh_authority_group_has_sh_authority1_sh_authority1`
    FOREIGN KEY (`sh_authority_id`)
    REFERENCES `sh_eduonline`.`sh_authority` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_authority_group_has_sh_authority1_sh_authority_group1`
    FOREIGN KEY (`sh_authority_group_id`)
    REFERENCES `sh_eduonline`.`sh_authority_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_parter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_parter` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UNIQUE_SH_PARTER` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '书商表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_parter_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(1) NOT NULL DEFAULT '1' COMMENT '0关1开',
  `num_reservation` VARCHAR(6) NOT NULL COMMENT '预定视频数量',
  PRIMARY KEY (`id`),
  INDEX `fk_sh_book_sh_parter1_idx` (`sh_parter_id` ASC),
  CONSTRAINT `fk_sh_book_sh_parter1`
    FOREIGN KEY (`sh_parter_id`)
    REFERENCES `sh_eduonline`.`sh_parter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '书';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_collection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_collection` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_user_id` INT(11) NULL DEFAULT NULL,
  `sh_video_base_id` INT(11) NULL DEFAULT NULL COMMENT '视频ID',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '收藏';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_course` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL COMMENT '课程名称',
  `short_name` VARCHAR(32) NULL DEFAULT NULL COMMENT '课程简写',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '课程表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_material_version`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_material_version` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `default` TINYINT(1) NULL DEFAULT '0' COMMENT '默认出版社 0-非默认	1-默认',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UNIQUE_SH_MATERIAL_VERSION` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '教材版本表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_course_grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_course_grade` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_course_id` INT(11) UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL COMMENT '1初中2高中',
  `sh_material_version_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sh_course_grade_sh_course1_idx` (`sh_course_id` ASC),
  INDEX `fk_sh_course_grade_sh_material_version1_idx` (`sh_material_version_id` ASC),
  CONSTRAINT `fk_sh_course_grade_sh_course1`
    FOREIGN KEY (`sh_course_id`)
    REFERENCES `sh_eduonline`.`sh_course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_course_grade_sh_material_version1`
    FOREIGN KEY (`sh_material_version_id`)
    REFERENCES `sh_eduonline`.`sh_material_version` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '课程年级表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_lecture` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '讲解人姓名',
  `level` VARCHAR(45) NULL DEFAULT NULL COMMENT '讲解人级别',
  `create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` DATETIME NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '视频讲解人表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_video_base`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_video_base` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_admin_user_id` INT(11) UNSIGNED NOT NULL COMMENT '后台管理用户id',
  `sh_course_id` INT(11) UNSIGNED NOT NULL,
  `sh_lecture_id` INT(11) UNSIGNED NOT NULL,
  `question_id` VARCHAR(45) NULL DEFAULT NULL COMMENT '题目ID',
  `title` VARCHAR(64) NOT NULL COMMENT '视频标题',
  `desc` VARCHAR(500) NULL DEFAULT NULL COMMENT '描述',
  `difficulty` VARCHAR(1) NOT NULL COMMENT '难度系数 1 2 3 4 5',
  `status` VARCHAR(1) NOT NULL DEFAULT '0' COMMENT '状态 0=已上架，1=未上架',
  `question_number` VARCHAR(32) NULL DEFAULT NULL COMMENT '题号',
  `profile` VARCHAR(128) NULL DEFAULT NULL COMMENT '简介',
  `updatetime` DATETIME NOT NULL COMMENT '更新时间',
  `qrcode` VARCHAR(128) NULL DEFAULT NULL COMMENT '二维码信息',
  PRIMARY KEY (`id`),
  INDEX `fk_sh_question_pastpaper_sh_admin_user1_idx` (`sh_admin_user_id` ASC),
  INDEX `fk_sh_video_base_sh_course1_idx` (`sh_course_id` ASC),
  INDEX `fk_sh_video_base_sh_lecture1_idx` (`sh_lecture_id` ASC),
  CONSTRAINT `fk_sh_question_pastpaper_sh_admin_user1`
    FOREIGN KEY (`sh_admin_user_id`)
    REFERENCES `sh_eduonline`.`sh_admin_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_base_sh_course1`
    FOREIGN KEY (`sh_course_id`)
    REFERENCES `sh_eduonline`.`sh_course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_base_sh_lecture1`
    FOREIGN KEY (`sh_lecture_id`)
    REFERENCES `sh_eduonline`.`sh_lecture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '视频公共基础信息表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_course_grade_has_sh_video_base`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_course_grade_has_sh_video_base` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_course_grade_id` INT(11) UNSIGNED NOT NULL,
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  `sort` INT(6) NOT NULL,
  `add_time` DATETIME NOT NULL,
  `video_type` VARCHAR(1) NOT NULL COMMENT '1真题模拟题2自编题3知识点',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uix_sh_course_has_video` (`sh_video_base_id` ASC, `sh_course_grade_id` ASC),
  INDEX `fk_sh_course_grade_has_sh_video_base_sh_video_base1_idx` (`sh_video_base_id` ASC),
  INDEX `fk_sh_course_grade_has_sh_video_base_sh_course_grade1_idx` (`sh_course_grade_id` ASC),
  CONSTRAINT `fk_sh_course_grade_has_sh_video_base_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '课程年级视频关系表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_feedback` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_user_id` INT(11) NULL DEFAULT NULL COMMENT '用户ID',
  `content` TEXT NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '意见反馈';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_grade` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(9) NULL DEFAULT NULL COMMENT '年级名称',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8
COMMENT = '年级表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_keyword`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_keyword` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '关键字内容',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '关键字表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_knowledge_point`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_knowledge_point` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL COMMENT '知识点内容',
  `parent_id` INT(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '父级id',
  `sh_course_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sh_knowledge_point_sh_course1_idx` (`sh_course_id` ASC),
  CONSTRAINT `fk_sh_knowledge_point_sh_course1`
    FOREIGN KEY (`sh_course_id`)
    REFERENCES `sh_eduonline`.`sh_course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '知识点表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_notice` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `notice` VARCHAR(255) NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '消息';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_play_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_play_history` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_user_id` INT(11) NULL DEFAULT NULL,
  `sh_video_base_id` INT(11) NULL DEFAULT NULL COMMENT '视频id',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '播放历史';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_problem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_problem` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_book_id` INT(11) NOT NULL,
  `status` VARCHAR(1) NOT NULL DEFAULT '1' COMMENT '0关1开',
  `content` VARCHAR(256) NULL DEFAULT NULL,
  `two_code` VARCHAR(255) NULL DEFAULT NULL,
  `two_code_content` VARCHAR(128) NULL DEFAULT NULL,
  `two_code_file_name` VARCHAR(128) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sh_problem_sh_book1_idx` (`sh_book_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '题表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_problem_has_sh_video_base`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_problem_has_sh_video_base` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_problem_id` INT(11) NOT NULL,
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  `video_type` VARCHAR(1) NOT NULL COMMENT '1真题模拟题2自编题3知识点',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `sh_problem_id_UNIQUE` (`sh_problem_id` ASC, `sh_video_base_id` ASC),
  INDEX `fk_sh_problem_has_sh_video_base_sh_video_base1_idx` (`sh_video_base_id` ASC),
  INDEX `fk_sh_problem_has_sh_video_base_sh_problem1_idx` (`sh_problem_id` ASC),
  CONSTRAINT `fk_sh_problem_has_sh_video_base_sh_problem1`
    FOREIGN KEY (`sh_problem_id`)
    REFERENCES `sh_eduonline`.`sh_problem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_problem_has_sh_video_base_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '题和视频关系表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_question_has_sh_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_question_has_sh_tag` (
  `sh_question_id` INT(11) UNSIGNED NOT NULL,
  `sh_tag_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`sh_question_id`, `sh_tag_id`),
  INDEX `fk_sh_question_has_sh_tag_sh_question1_idx` (`sh_question_id` ASC),
  CONSTRAINT `fk_sh_question_has_sh_tag_sh_question1`
    FOREIGN KEY (`sh_question_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_question_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_question_type` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL COMMENT '题型名称',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 60
DEFAULT CHARACTER SET = utf8
COMMENT = '题型表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_questionbank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_questionbank` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(16) NULL DEFAULT NULL COMMENT '题库名称',
  `type` CHAR(1) NOT NULL COMMENT '0=真题题库，1=自编题库（预留，暂时不用）',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '题库表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_questionbank_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_questionbank_course` (
  `sh_questionbank_id` INT(11) UNSIGNED NOT NULL,
  `sh_course_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`sh_questionbank_id`, `sh_course_id`),
  INDEX `fk_sh_questionbank_has_sh_course_sh_course1_idx` (`sh_course_id` ASC),
  INDEX `fk_sh_questionbank_has_sh_course_sh_questionbank1_idx` (`sh_questionbank_id` ASC),
  CONSTRAINT `fk_sh_questionbank_has_sh_course_sh_course1`
    FOREIGN KEY (`sh_course_id`)
    REFERENCES `sh_eduonline`.`sh_course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_questionbank_has_sh_course_sh_questionbank1`
    FOREIGN KEY (`sh_questionbank_id`)
    REFERENCES `sh_eduonline`.`sh_questionbank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '题库科目对应表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_questionbank_question_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_questionbank_question_type` (
  `sh_questionbank_id` INT(11) UNSIGNED NOT NULL,
  `sh_question_type_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`sh_questionbank_id`, `sh_question_type_id`),
  INDEX `fk_sh_questionbank_has_sh_question_type_sh_question_type1_idx` (`sh_question_type_id` ASC),
  INDEX `fk_sh_questionbank_has_sh_question_type_sh_questionbank1_idx` (`sh_questionbank_id` ASC),
  CONSTRAINT `fk_sh_questionbank_has_sh_question_type_sh_questionbank1`
    FOREIGN KEY (`sh_questionbank_id`)
    REFERENCES `sh_eduonline`.`sh_questionbank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_questionbank_has_sh_question_type_sh_question_type1`
    FOREIGN KEY (`sh_question_type_id`)
    REFERENCES `sh_eduonline`.`sh_question_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '题库题型对应关系表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_questionbank_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_questionbank_type` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_questionbank_id` INT(11) UNSIGNED NOT NULL,
  `name` VARCHAR(16) NOT NULL COMMENT '题库版本名称',
  PRIMARY KEY (`id`),
  INDEX `fk_sh_questionbank_type_sh_questionbank1_idx` (`sh_questionbank_id` ASC),
  CONSTRAINT `fk_sh_questionbank_type_sh_questionbank1`
    FOREIGN KEY (`sh_questionbank_id`)
    REFERENCES `sh_eduonline`.`sh_questionbank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '题库版本表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_questionbank_year`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_questionbank_year` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_questionbank_id` INT(11) UNSIGNED NOT NULL,
  `year` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uidx_questionbank_year` (`sh_questionbank_id` ASC, `year` ASC),
  INDEX `fk_sh_questionbank_year_sh_questionbank1_idx` (`sh_questionbank_id` ASC),
  CONSTRAINT `fk_sh_questionbank_year_sh_questionbank1`
    FOREIGN KEY (`sh_questionbank_id`)
    REFERENCES `sh_eduonline`.`sh_questionbank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '真题模拟题所属年份关系表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_recommend`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_recommend` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `add_time` DATETIME NOT NULL,
  `top_time` DATETIME NOT NULL,
  `location` VARCHAR(1) NOT NULL COMMENT '1位置12位置2位置3',
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `logo` VARCHAR(128) NOT NULL,
  `type` VARCHAR(1) NULL DEFAULT NULL COMMENT '类型：1-视频库，2-课程库',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '推荐表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_recommend_has_sh_course_grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_recommend_has_sh_course_grade` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_recommend_id` INT(11) NOT NULL,
  `sh_course_grade_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sh_recommend_has_sh_course_grade_sh_course_grade1_idx` (`sh_course_grade_id` ASC),
  INDEX `fk_sh_recommend_has_sh_course_grade_sh_recommend1_idx` (`sh_recommend_id` ASC),
  CONSTRAINT `fk_sh_recommend_has_sh_course_grade_sh_recommend1`
    FOREIGN KEY (`sh_recommend_id`)
    REFERENCES `sh_eduonline`.`sh_recommend` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_recommend_has_sh_course_grade_sh_course_grade1`
    FOREIGN KEY (`sh_course_grade_id`)
    REFERENCES `sh_eduonline`.`sh_course_grade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_recommend_has_sh_video_base`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_recommend_has_sh_video_base` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_recommend_id` INT(11) NOT NULL,
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  `add_time` DATETIME NOT NULL,
  `top_time` DATETIME NOT NULL,
  `video_type` VARCHAR(1) NOT NULL COMMENT '1真题模拟题2自编题3知识点',
  `dimension` VARCHAR(1) NOT NULL COMMENT '筛选维度1初中2高中',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uix_sh_recommend_has_sh_video_base` (`sh_recommend_id` ASC, `sh_video_base_id` ASC),
  INDEX `fk_sh_recommend_has_sh_video_base_sh_video_base1_idx` (`sh_video_base_id` ASC),
  INDEX `fk_sh_recommend_has_sh_video_base_sh_recommend1_idx` (`sh_recommend_id` ASC),
  CONSTRAINT `fk_sh_recommend_has_sh_video_base_sh_recommend1`
    FOREIGN KEY (`sh_recommend_id`)
    REFERENCES `sh_eduonline`.`sh_recommend` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_recommend_has_sh_video_base_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '推荐视频关系表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_school` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_area_id` INT(11) UNSIGNED NOT NULL COMMENT '学校所在地',
  `name` VARCHAR(32) NULL DEFAULT NULL COMMENT '学校名称',
  PRIMARY KEY (`id`),
  INDEX `fk_sh_school_sh_area_idx` (`sh_area_id` ASC),
  CONSTRAINT `fk_sh_school_sh_area`
    FOREIGN KEY (`sh_area_id`)
    REFERENCES `sh_eduonline`.`sh_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '学校表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_user` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_area_id` INT(11) UNSIGNED NULL DEFAULT NULL COMMENT '所在城市',
  `sh_grade_id` INT(11) UNSIGNED NULL DEFAULT NULL COMMENT '所在年级',
  `sh_school_id` INT(11) UNSIGNED NULL DEFAULT NULL COMMENT '所在学校',
  `user_class` INT(11) NULL DEFAULT NULL COMMENT '班级',
  `tel` VARCHAR(11) NOT NULL COMMENT '手机号',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  `name` VARCHAR(16) NULL DEFAULT NULL COMMENT '姓名',
  `nick` VARCHAR(45) NULL DEFAULT NULL COMMENT '昵称',
  `sex` ENUM('0','1') NULL DEFAULT '0' COMMENT '性别：0-男，1-女',
  `face` VARCHAR(255) NULL DEFAULT NULL COMMENT '头像',
  `create_time` DATETIME NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  INDEX `fk_sh_user_sh_area_idx` (`sh_area_id` ASC),
  INDEX `fk_sh_user_sh_grade_idx` (`sh_grade_id` ASC),
  INDEX `fk_sh_user_sh_school_idx` (`sh_school_id` ASC),
  CONSTRAINT `fk_sh_user_sh_area`
    FOREIGN KEY (`sh_area_id`)
    REFERENCES `sh_eduonline`.`sh_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_user_sh_grade`
    FOREIGN KEY (`sh_grade_id`)
    REFERENCES `sh_eduonline`.`sh_grade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_user_sh_school`
    FOREIGN KEY (`sh_school_id`)
    REFERENCES `sh_eduonline`.`sh_school` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '用户信息表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_user_notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_user_notice` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_user_id` INT(11) NULL DEFAULT NULL COMMENT '用户id',
  `sh_notice_id` INT(11) NULL DEFAULT NULL COMMENT '消息id',
  `readed` VARCHAR(45) NULL DEFAULT NULL COMMENT '是否已读，0未读 ， 1已读',
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_user_thirdpart_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_user_thirdpart_login` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `platform` VARCHAR(45) NULL DEFAULT NULL,
  `platform_token` VARCHAR(45) NOT NULL COMMENT '第三方的token',
  `platform_name` VARCHAR(45) NOT NULL COMMENT '第三方平台上的用户名',
  `sh_user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_vertify_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_vertify_code` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `vertify_code` VARCHAR(8) NULL DEFAULT NULL COMMENT '验证码',
  `tel` VARCHAR(11) NULL DEFAULT NULL COMMENT '手机号',
  `live_time` INT(11) NULL DEFAULT NULL COMMENT '有效时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '验证码表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_video_base_keyword`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_video_base_keyword` (
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  `sh_keyword_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`sh_video_base_id`, `sh_keyword_id`),
  INDEX `fk_sh_video_base_has_sh_keyword_sh_keyword1_idx` (`sh_keyword_id` ASC),
  INDEX `fk_sh_video_base_has_sh_keyword_sh_video_base1_idx` (`sh_video_base_id` ASC),
  CONSTRAINT `fk_sh_video_base_has_sh_keyword_sh_keyword1`
    FOREIGN KEY (`sh_keyword_id`)
    REFERENCES `sh_eduonline`.`sh_keyword` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_base_has_sh_keyword_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '视频与关键字关系表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_video_base_knowledge_point`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_video_base_knowledge_point` (
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  `sh_knowledge_point_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`sh_video_base_id`, `sh_knowledge_point_id`),
  INDEX `fk_sh_video_base_has_sh_knowledge_point_sh_knowledge_point1_idx` (`sh_knowledge_point_id` ASC),
  INDEX `fk_sh_video_base_has_sh_knowledge_point_sh_video_base1_idx` (`sh_video_base_id` ASC),
  CONSTRAINT `fk_sh_video_base_has_sh_knowledge_point_sh_knowledge_point1`
    FOREIGN KEY (`sh_knowledge_point_id`)
    REFERENCES `sh_eduonline`.`sh_knowledge_point` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_base_has_sh_knowledge_point_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '视频知识点关系表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_video_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_video_detail` (
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  `type` VARCHAR(10) NOT NULL COMMENT '视频格式',
  `url` VARCHAR(256) NOT NULL COMMENT '视频地址',
  `updatetime` DATETIME NOT NULL,
  `store_info` VARCHAR(128) NULL DEFAULT NULL,
  `store_type` VARCHAR(1) NULL DEFAULT NULL COMMENT '存储类型 0=自有服务器，1=其他服务器',
  `video_duration` VARCHAR(45) NULL DEFAULT NULL COMMENT '视频时长',
  PRIMARY KEY (`type`, `sh_video_base_id`),
  INDEX `fk_sh_video_detail_sh_video_base1_idx` (`sh_video_base_id` ASC),
  CONSTRAINT `fk_sh_video_detail_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '同一个视频，不同格式的具体信息';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_video_pastpaper`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_video_pastpaper` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  `sh_questionbank_id` INT(11) UNSIGNED NOT NULL,
  `sh_questionbank_year_id` INT(11) UNSIGNED NOT NULL,
  `sh_question_type_id` INT(11) UNSIGNED NOT NULL,
  `sh_questionbank_type_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sh_video_pastpaper_sh_questionbank1_idx` (`sh_questionbank_id` ASC),
  INDEX `fk_sh_video_pastpaper_sh_questionbank_year1_idx` (`sh_questionbank_year_id` ASC),
  INDEX `fk_sh_video_pastpaper_sh_video_base1_idx` (`sh_video_base_id` ASC),
  INDEX `fk_sh_video_pastpaper_sh_question_type1_idx` (`sh_question_type_id` ASC),
  INDEX `fk_sh_video_pastpaper_sh_questionbank_type1_idx` (`sh_questionbank_type_id` ASC),
  CONSTRAINT `fk_sh_video_pastpaper_sh_questionbank1`
    FOREIGN KEY (`sh_questionbank_id`)
    REFERENCES `sh_eduonline`.`sh_questionbank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_pastpaper_sh_questionbank_type1`
    FOREIGN KEY (`sh_questionbank_type_id`)
    REFERENCES `sh_eduonline`.`sh_questionbank_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_pastpaper_sh_questionbank_year1`
    FOREIGN KEY (`sh_questionbank_year_id`)
    REFERENCES `sh_eduonline`.`sh_questionbank_year` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_pastpaper_sh_question_type1`
    FOREIGN KEY (`sh_question_type_id`)
    REFERENCES `sh_eduonline`.`sh_question_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_pastpaper_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '真题模拟题具体信息表';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_video_pic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_video_pic` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  `title` VARCHAR(64) NULL DEFAULT NULL,
  `description` VARCHAR(256) NULL DEFAULT NULL,
  `store_info` VARCHAR(64) NULL DEFAULT NULL,
  `store_type` VARCHAR(1) NULL DEFAULT NULL COMMENT '存储类型 0=自有服务器，1=其他服务器',
  `url` VARCHAR(255) NULL DEFAULT NULL COMMENT '图片链接',
  PRIMARY KEY (`id`),
  INDEX `fk_sh_video_pic_sh_video_base1_idx` (`sh_video_base_id` ASC),
  CONSTRAINT `fk_sh_video_pic_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '视频的截图信息';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_video_point`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_video_point` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sh_video_point_sh_video_base1_idx` (`sh_video_base_id` ASC),
  CONSTRAINT `fk_sh_video_point_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '知识点信息';


-- -----------------------------------------------------
-- Table `sh_eduonline`.`sh_video_self`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sh_eduonline`.`sh_video_self` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sh_video_base_id` INT(11) UNSIGNED NOT NULL,
  `type` VARCHAR(1) NOT NULL COMMENT '题目性质：0=改编，1=自编',
  `sh_question_type_id` INT(11) UNSIGNED NOT NULL,
  `resource` VARCHAR(128) NULL DEFAULT NULL COMMENT '改编题来源',
  PRIMARY KEY (`id`),
  INDEX `fk_sh_video_self_sh_question_type1_idx` (`sh_question_type_id` ASC),
  INDEX `fk_sh_video_self_sh_video_base1_idx` (`sh_video_base_id` ASC),
  CONSTRAINT `fk_sh_video_self_sh_question_type1`
    FOREIGN KEY (`sh_question_type_id`)
    REFERENCES `sh_eduonline`.`sh_question_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sh_video_self_sh_video_base1`
    FOREIGN KEY (`sh_video_base_id`)
    REFERENCES `sh_eduonline`.`sh_video_base` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '自编题信息';



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
