
DROP TABLE IF EXISTS `properties`;

CREATE TABLE `properties` (
  `property_id` char(36) NOT NULL,
  `name`        VARCHAR(255)     NOT NULL,
  `value`       VARCHAR(255)     NOT NULL,
  `type`        VARCHAR(45)      NOT NULL,
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;