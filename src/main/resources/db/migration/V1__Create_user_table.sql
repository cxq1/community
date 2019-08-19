CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `token` char(255) DEFAULT NULL,
  `gmtcreate` bigint(20) DEFAULT NULL,
  `gmtmodified` bigint(20) DEFAULT NULL,
  `bio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;