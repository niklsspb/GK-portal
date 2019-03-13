
/*!40101 SET NAMES utf8 */;
/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `flat_property` */

create TABLE `flat_property` (
  `id` char(36) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'описание',
  `css_style_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'css style',
  `position` int(11) NOT NULL COMMENT 'позиция для отображения',
  `date1_enabled` bit(1) NOT NULL COMMENT 'нужна ли дата 1',
  `date2_enabled` bit(1) NOT NULL COMMENT 'нужна ли дата 2',
  `comment_enabled` bit(1) NOT NULL COMMENT 'нужны ли комментарии',
  `date1_description` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'описание к дата1',
  `date2_description` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'описание к дата2',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT 'на будущее, всегда отбираем только =1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `ftal_flat_property` */

create TABLE `flat_flat_property` (
  `id` char(36) COLLATE utf8_unicode_ci NOT NULL,
  `flat_id` char(36) COLLATE utf8_unicode_ci NOT NULL COMMENT 'квартира',
  `flat_property_id` char(36) COLLATE utf8_unicode_ci NOT NULL COMMENT 'свойство',
  `date_change` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'дата создания',
  `changed_by_contact_id` char(36)  COLLATE utf8_unicode_ci NOT NULL COMMENT 'кто менял последний раз',
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'пояснение',
  `date1` date DEFAULT NULL COMMENT 'дата, н-р начала',
  `date2` date DEFAULT NULL COMMENT 'дата, н-р конца',
  PRIMARY KEY (`id`),
  KEY `flat` (`flat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
