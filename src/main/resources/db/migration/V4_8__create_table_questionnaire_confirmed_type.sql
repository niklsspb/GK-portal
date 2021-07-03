DROP TABLE IF EXISTS `questionnaire_confirmed_type`;

CREATE TABLE `questionnaire_confirmed_type` (
  `id` CHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE=InnoDB DEFAULT CHARSET=utf8;