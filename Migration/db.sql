/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - cloud_sadas
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `cloud_sadas`;

USE `cloud_sadas`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `m_id` int(10) NOT NULL auto_increment,
  `m_admin` varchar(50) default NULL,
  `m_pass` varchar(50) default NULL,
  `m_master_key` varchar(50) default NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`m_id`,`m_admin`,`m_pass`,`m_master_key`) values (1,'admin','admin','678abc91123abc45');

/*Table structure for table `m_cloud` */

DROP TABLE IF EXISTS `m_cloud`;

CREATE TABLE `m_cloud` (
  `c_code` int(20) NOT NULL auto_increment,
  `c_url` varchar(50) default NULL,
  `c_uname` varchar(50) default NULL,
  `c_pwd` varchar(50) default NULL,
  PRIMARY KEY  (`c_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_cloud` */

insert into `m_cloud` (`c_code`,`c_url`,`c_uname`,`c_pwd`) values (1,'ftp.drivehq.com','shalinim','dhsnew');
insert into `m_cloud` (`c_code`,`c_url`,`c_uname`,`c_pwd`) values (2,'ftp.drivehq.com','blrstore1','*blrstore123');

/*Table structure for table `m_deleted_files` */

DROP TABLE IF EXISTS `m_deleted_files`;

CREATE TABLE `m_deleted_files` (
  `f_no` int(10) NOT NULL auto_increment,
  `f_name` varchar(50) default NULL,
  `m_id` varchar(50) default NULL,
  `f_date_time` varchar(50) default NULL,
  `recovery_status` varchar(100) default NULL,
  PRIMARY KEY  (`f_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_deleted_files` */

/*Table structure for table `m_fileblocks` */

DROP TABLE IF EXISTS `m_fileblocks`;

CREATE TABLE `m_fileblocks` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` varchar(40) default NULL,
  `file_name` varchar(30) default NULL,
  `block_names` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_fileblocks` */

/*Table structure for table `m_lba` */

DROP TABLE IF EXISTS `m_lba`;

CREATE TABLE `m_lba` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` varchar(30) default NULL,
  `file_name` varchar(30) default NULL,
  `m_lba` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_lba` */

/*Table structure for table `m_live_files` */

DROP TABLE IF EXISTS `m_live_files`;

CREATE TABLE `m_live_files` (
  `f_no` int(10) NOT NULL auto_increment,
  `f_name` varchar(50) default NULL,
  `m_id` varchar(50) default NULL,
  `f_date_time` varchar(50) default NULL,
  `f_status` varchar(100) default NULL,
  `f_subject` varchar(100) default NULL,
  `f_living_time` varchar(100) default NULL,
  PRIMARY KEY  (`f_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_live_files` */

/*Table structure for table `m_recovery` */

DROP TABLE IF EXISTS `m_recovery`;

CREATE TABLE `m_recovery` (
  `reco_id` int(10) NOT NULL auto_increment,
  `f_name` varchar(50) default NULL,
  `m_id` varchar(50) default NULL,
  `reco_date_time` varchar(20) default NULL,
  PRIMARY KEY  (`reco_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_recovery` */

/*Table structure for table `m_transaction` */

DROP TABLE IF EXISTS `m_transaction`;

CREATE TABLE `m_transaction` (
  `t_no` int(10) NOT NULL auto_increment,
  `t_date` varchar(100) NOT NULL,
  `t_time` varchar(100) NOT NULL,
  `m_loginid` varchar(50) NOT NULL,
  `f_name` varchar(50) default NULL,
  `f_status` varchar(50) default NULL,
  PRIMARY KEY  (`t_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_transaction` */

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `m_id` int(10) NOT NULL auto_increment,
  `m_user` varchar(50) NOT NULL,
  `m_pass` varchar(50) default NULL,
  `m_name` varchar(50) default NULL,
  `m_city` varchar(50) default NULL,
  `m_email` varchar(50) default NULL,
  `m_key1` varchar(50) default NULL,
  PRIMARY KEY  (`m_id`,`m_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
