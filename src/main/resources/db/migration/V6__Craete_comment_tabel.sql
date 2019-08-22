CREATE TABLE `comment` (
`id`  bigint NOT NULL AUTO_INCREMENT ,
`parent_id`  bigint NOT NULL ,
`type`  int NOT NULL ,
`commentator`  int NOT NULL ,
`gmt_create`  bigint NOT NULL ,
`gmt_modified`  bigint NOT NULL ,
`like_count`  bigint NOT NULL DEFAULT 0 ,
PRIMARY KEY (`id`)
)
;