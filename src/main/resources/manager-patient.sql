DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `date` varchar(10) NOT NULL,
  `patient_number` bigint(20) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `patient_information` varchar(50) DEFAULT NULL,
  `local` varchar(50) DEFAULT NULL,
  `travel` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `actions` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `route` varchar(50) DEFAULT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modification_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `exposure` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_number` (`patient_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `password` varchar(128) NOT NULL DEFAULT '',
PRIMARY KEY (`id`),
UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
# Insert an admin for login
insert into manager(name,password) values('admin','123456');


DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `comment_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `text` text NOT NULL,
  `state` char(10) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_id` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;