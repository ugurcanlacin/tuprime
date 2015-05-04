CREATE DATABASE `sportclubsystem`;

CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user`(
`id` int(11) not null auto_increment primary key,
`username` nvarchar(64) not null unique,
`password_hash` nvarchar(255) not null,
`name` nvarchar(64) not null,
`surname` nvarchar(64) default null,
`email` nvarchar(64) not null unique,
`active` tinyint(1) NOT NULL DEFAULT '0',
`creation_timestamp` date NOT NULL,
`activation_hash` varchar(40)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `sportclubsystem`.`role`(
`id` int(11) not null auto_increment primary key,
`role` nvarchar(32) not null default 'ROLE_USER'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `sportclubsystem`.`diet`(
`id` int(11) not null auto_increment primary key,
`diet` nvarchar(1000),
`timestamp` date not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `sportclubsystem`.`workout`(
`id` int(11) not null auto_increment primary key,
`workout_program` nvarchar(1000),
`timestamp` date not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sportclubsystem`.`personal_details`(
`id` int(11) not null auto_increment primary key,
`weight` nvarchar(20),
`chest` nvarchar(20),
`waist` nvarchar(20),
`hips` nvarchar(20),
`biceps` nvarchar(20),
`timestamp` date not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user_roles`(
`user_id` int(11) not null,
`role_id`int(11) not null,
KEY `user_r` (`user_id`),  
KEY `role` (`role_id`),  
CONSTRAINT `user_r` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user_diet`(
`user_id` int(11) not null,
`diet_id`int(11) not null,
KEY `user_d` (`user_id`),  
KEY `diet` (`diet_id`),  
CONSTRAINT `user_d` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `diet` FOREIGN KEY (`diet_id`) REFERENCES `diet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user_workout`(
`user_id` int(11) not null,
`workout_id`int(11) not null,
KEY `user_w` (`user_id`),  
KEY `workout` (`workout_id`),  
CONSTRAINT `user_w` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `workout` FOREIGN KEY (`workout_id`) REFERENCES `workout` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user_pdetails`(
`user_id` int(11) not null,
`pdetails_id`int(11) not null,
KEY `user_pd` (`user_id`),  
KEY `pdetails` (`pdetails_id`),  
CONSTRAINT `user_pd` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `pdetails` FOREIGN KEY (`pdetails_id`) REFERENCES `personal_details` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)