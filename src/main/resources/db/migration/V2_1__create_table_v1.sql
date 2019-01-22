/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.7.24-log : Database - support_boot_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `build_porch_config` */

DROP TABLE IF EXISTS `build_porch_config`;

CREATE TABLE `build_porch_config` (
  `housing` int(11) NOT NULL COMMENT 'номер дома',
  `porch` int(11) NOT NULL COMMENT 'номер подъезда',
  `floors_count` int(11) NOT NULL COMMENT 'кол-во этажей',
  `flat_quantity_floor` int(11) NOT NULL COMMENT 'кол-во квартир на этаже',
  `flat_from_floor` int(11) NOT NULL COMMENT 'с какого этажа начинаются квартиры',
  `flat_quatity_start_floor` int(11) NOT NULL COMMENT 'кол-во квартир на стартовом этаже',
  `record_builded` bit(1) NOT NULL DEFAULT b'0' COMMENT 'записи квартир созданы, фильтр для отбора рабочих записей',
  `porch_num_from_right` bit(1) NOT NULL DEFAULT b'0' COMMENT 'нумерация квартир справа, а не слева внутри подъезда как везде',
  `housing_num_from_right` bit(1) NOT NULL DEFAULT b'0' COMMENT 'строительная нумерация справа по этажно через весь дом, а не слева как в остальных',
  `ident_flat_count` int(11) NOT NULL DEFAULT '0' COMMENT 'квартир с известными собственниками',
  `build_housing` int(11) NOT NULL COMMENT 'строительный номер дома',
  `build_porch` int(11) NOT NULL COMMENT 'строительный номер подъезда, про запас',
  `all_flat_count` int(11) GENERATED ALWAYS AS ((((`floors_count` - `flat_from_floor`) * `flat_quantity_floor`) + `flat_quatity_start_floor`)) VIRTUAL COMMENT 'всего квартир в подъезде - вычисляемое поле',
  PRIMARY KEY (`housing`,`porch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `flats` */

DROP TABLE IF EXISTS `flats`;

CREATE TABLE `flats` (
  `housing` int(11) NOT NULL COMMENT 'дом',
  `porch` int(11) NOT NULL COMMENT 'подъезд',
  `floor` int(11) NOT NULL COMMENT 'этаж',
  `flat` int(11) NOT NULL COMMENT 'квартира',
  `flat_build` int(11) NOT NULL COMMENT 'строительный номер',
  `flat_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `square` float DEFAULT NULL COMMENT 'кв.м. без учёта лоджии/балкона',
  `room_count` int(11) DEFAULT NULL COMMENT 'кол-во комнат',
  `riser_num` int(11) NOT NULL DEFAULT '0' COMMENT 'номер стояка',
  `housing_build` int(11) NOT NULL COMMENT 'строительный номер дома',
  `owners_count` int(11) DEFAULT NULL COMMENT 'кол-во собственников',
  `porch_build` int(11) NOT NULL COMMENT 'строительный номер подъезда',
  PRIMARY KEY (`flat_id`),
  UNIQUE KEY `num` (`housing`,`porch`,`floor`,`flat`),
  KEY `num_build` (`housing_build`,`porch_build`,`floor`,`flat_build`)
) ENGINE=InnoDB AUTO_INCREMENT=1698 DEFAULT CHARSET=utf8;

/*Table structure for table `user_type` */

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `user_type_id` int(11) NOT NULL,
  `type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `e-mail` varchar(45) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `password` char(80) NOT NULL,
  `registration_email_code` varchar(10) DEFAULT NULL COMMENT 'код подтверждения e-mail ',
  `registration_phone_code` varchar(10) DEFAULT NULL COMMENT 'код подтверждения телефона',
  `confirmed` tinyint(1) NOT NULL,
  `user_type_id` int(11) NOT NULL,
  `user_tg_id` int(11) DEFAULT NULL,
  `user_tg_confirm_code` varchar(10) DEFAULT NULL COMMENT 'код подтверждения telegram',
  PRIMARY KEY (`user_id`),
  KEY `fk_users_user_type_idx` (`user_type_id`),
  CONSTRAINT `fk_users_user_type` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`user_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `users_has_flats` */

DROP TABLE IF EXISTS `users_has_flats`;

CREATE TABLE `users_has_flats` (
  `users_id` int(11) NOT NULL,
  `flats_flat_id` int(11) NOT NULL,
  PRIMARY KEY (`users_id`,`flats_flat_id`),
  KEY `fk_users_has_flats_flats1_idx` (`flats_flat_id`),
  CONSTRAINT `fk_users_has_flats_flats1` FOREIGN KEY (`flats_flat_id`) REFERENCES `flats` (`flat_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_flats_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
