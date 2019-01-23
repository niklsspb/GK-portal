

DROP TABLE IF EXISTS `properties`;

CREATE TABLE `properties` (
  `property_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255)     NOT NULL,
  `value`       VARCHAR(255)     NOT NULL,
  `type`        VARCHAR(45)      NOT NULL,
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;